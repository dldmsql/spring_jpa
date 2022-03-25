package com.example.spring_jpa.service;


import com.example.spring_jpa.entity.Employee;
import com.example.spring_jpa.entity.Insurance;
import com.example.spring_jpa.entity.InsurancePermitted;
import com.example.spring_jpa.repository.EmployeeRepository;
import com.example.spring_jpa.repository.InsuranceRepository;
import com.example.spring_jpa.request.InsuranceCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DevelopService {
    private final InsuranceRepository insuranceRepository;
    private final EmployeeRepository employeeRepository;

    // 상품 개발
    public Insurance createInsurance(InsuranceCreationRequest insurance){
        Optional<Employee> employee = employeeRepository.findById(insurance.getEmployeeId());
        if(!employee.isPresent()){
            throw new EntityNotFoundException(
                    "Employee Not Found!!!!"
            );
        }
        Insurance insuranceToCreate = new Insurance();
        BeanUtils.copyProperties(insurance, insuranceToCreate);
        insuranceToCreate.setEmployee(employee.get());
        insuranceToCreate.setInsurancePermitted(InsurancePermitted.nonapprove);
        return insuranceRepository.save(insuranceToCreate);
    }
    // 상품 삭제
    public void deleteInsurance( Long id ){
        insuranceRepository.deleteById(id);
    }

    // 미승인 상품 리스트
    public List<Insurance> readInsurances(){
        return insuranceRepository.findByInsurancePermitted(InsurancePermitted.nonapprove);
    }
    // 상품 인가
    public Insurance updateInsurance(Long id){
        Optional<Insurance> optionalInsurance = insuranceRepository.findById(id);
        if (!optionalInsurance.isPresent()){
            throw new EntityNotFoundException(
                    "Insurance not present in the database"
            );
        }
        Insurance insurance = optionalInsurance.get();
        insurance.setInsurancePermitted(InsurancePermitted.approve);
        insuranceRepository.save(insurance);
        return insurance;
    }
}

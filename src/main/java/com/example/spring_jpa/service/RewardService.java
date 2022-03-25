package com.example.spring_jpa.service;


import com.example.spring_jpa.entity.*;
import com.example.spring_jpa.repository.*;
import com.example.spring_jpa.request.AccidentRequest;
import com.example.spring_jpa.request.RewardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RewardService {

    private final RewardRepository rewardRepository;
    private final AccidentRepository accidentRepository;
    private final ContractRepository contractRepository;
    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;

    // 사고 접수
/*
    시스템은 사고 접수하기 폼을 보여준다.
    화면에는 ( 고객 아이디, 사고 발생 날짜, 사고 장소, 사고 유형 )이 보여진다.
    고객은 사고 접수 폼을 작성한 후, 하단의 저장 버튼을 누른다.
*/

    // 사고 접수
    public Accident createAccident(AccidentRequest request ){
        Optional<Customer> customer = customerRepository.findById(request.getCustomerId());

        Accident accident = new Accident();
        BeanUtils.copyProperties(request, accident);
        accident.setCustomer(customer.get());
        accident.setDate(LocalDate.now());
        accident.setAccidentStatus(AccidentStatus.NONCOMPLETED);
        return accidentRepository.save(accident);
    }

    // 사고 처리
/*    시스템은 미처리된 사고 리스트를 보여준다.
    직원은 한 건의 사고를 선택한다.
    시스템은 사고의 정보와 고객의 계약 내용을 보여주고, 보상 / 미보상 버튼을 보여준다.
    직원이 보상 버튼을 누른 경우, 시스템은 보상하기 폼을 보여준다.
    화면에는 ( 직원 아이디, 보상 금액, 이유 )를 보여준다.
    직원이 미보상 버튼을 누른 경우, 시스템은 미보상 폼을 보여준다.
    화면에는 ( 직원 아이디, 보상 금액(0원), 이유 ) 를 보여준다.*/

    public List<Accident> readAccidents(){
        return accidentRepository.findByAccidentStatus(AccidentStatus.NONCOMPLETED);
    }
    public Accident readAccident(Long id){
        Optional<Accident> accident = accidentRepository.findByCustomerId(id);
        if(!accident.isPresent()){
            throw new EntityNotFoundException(
                    "Accident not present in the database"
            );
        }
        Customer customer = accident.get().getCustomer();
        List<Contract> contract = customer.getContract();
        if( contract.isEmpty() ){
            throw new IndexOutOfBoundsException(
                    "Customer doesn't have any Contract"
            );
        }
        return accident.get();
     }
     public Reward createReward(RewardRequest request ){
        Optional<Employee> employee = employeeRepository.findById(request.getEmployeeId());
        if(!employee.isPresent()){
            throw new EntityNotFoundException(
                    "Employee not present in the database"
            );
        }
        Optional<Accident> accident = accidentRepository.findById(request.getAccidentId());
        if(accident.get().getAccidentStatus() != AccidentStatus.NONCOMPLETED){
            throw new EntityNotFoundException(
                    "Accident not present in the database"
            );
        }
        accident.get().setAccidentStatus(AccidentStatus.COMPLETED);

        Optional<Contract> contract = contractRepository.findById(request.getContractId());

        Reward reward = new Reward();
        BeanUtils.copyProperties(request, reward);
        reward.setAccident(accident.get());
        reward.setContract(contract.get());
        reward.setEmployee(employee.get());
        reward.setDate(LocalDate.now());
        return rewardRepository.save(reward);
     }

    public void deleteAccident(Long accidentId) {
        accidentRepository.deleteById(accidentId);
    }
}

package com.example.spring_jpa.service;


import com.example.spring_jpa.entity.Employee;
import com.example.spring_jpa.repository.EmployeeRepository;
import com.example.spring_jpa.request.EmployeeCreationRequest;
import com.example.spring_jpa.request.EmployeeLoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainService {
    private final EmployeeRepository employeeRepository;

    // 직원 회원가입
    public Employee createEmployee(EmployeeCreationRequest request){
        Employee employee = new Employee();
        BeanUtils.copyProperties(request, employee);
        return employeeRepository.save(employee);
    }
    // 로그인
    public Employee readEmployee(EmployeeLoginRequest request){
        Optional<Employee> employee = employeeRepository.findByIdAndPw(request.getId(), request.getPw());
        return employee.get();
    }

    public List<Employee> readEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }
}

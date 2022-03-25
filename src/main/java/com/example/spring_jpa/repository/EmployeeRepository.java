package com.example.spring_jpa.repository;


import com.example.spring_jpa.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    Optional<Employee> findByIdAndPw(Long employeeId, Long pw);
}

package com.example.spring_jpa.repository;

import com.example.spring_jpa.entity.Insurance;
import com.example.spring_jpa.entity.InsurancePermitted;

import java.util.List;

public interface InsuranceRepository extends JpaRepository<Insurance, Long>{
    List<Insurance> findByInsurancePermitted(InsurancePermitted insurancePermitted);
}

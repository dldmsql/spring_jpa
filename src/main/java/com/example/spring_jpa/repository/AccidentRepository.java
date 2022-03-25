package com.example.spring_jpa.repository;



import com.example.spring_jpa.entity.Accident;
import com.example.spring_jpa.entity.AccidentStatus;

import java.util.List;
import java.util.Optional;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
    List<Accident> findByAccidentStatus(AccidentStatus accidentStatus);
    Optional<Accident> findByCustomerId ( Long customerId );
}

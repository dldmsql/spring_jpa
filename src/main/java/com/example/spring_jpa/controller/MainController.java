package com.example.spring_jpa.controller;

import com.example.spring_jpa.entity.Employee;
import com.example.spring_jpa.request.EmployeeCreationRequest;
import com.example.spring_jpa.request.EmployeeLoginRequest;
import com.example.spring_jpa.service.MainService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/main")
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;

    @GetMapping
    public ResponseEntity<List<Employee>> readEmployees() {
        return ResponseEntity.ok(mainService.readEmployees());
    }

    @PostMapping ("/signup")
    public ResponseEntity createEmployee(@RequestBody EmployeeCreationRequest request){
        return ResponseEntity.ok(mainService.createEmployee(request));
    }
    @PostMapping("/login")
    public ResponseEntity readEmployee(@RequestBody EmployeeLoginRequest request){
      return ResponseEntity.ok(mainService.readEmployee(request));
    }
}

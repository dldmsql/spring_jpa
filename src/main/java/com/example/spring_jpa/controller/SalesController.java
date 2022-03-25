package com.example.spring_jpa.controller;

import com.example.spring_jpa.entity.Contract;
import com.example.spring_jpa.entity.Customer;
import com.example.spring_jpa.entity.Insurance;
import com.example.spring_jpa.request.ContractUpdateRequest;
import com.example.spring_jpa.request.CustomerCreationRequest;
import com.example.spring_jpa.request.InsuranceContractRequest;
import com.example.spring_jpa.request.InsuranceReadsRequest;
import com.example.spring_jpa.service.SalesService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sale")
@RequiredArgsConstructor
public class SalesController {
    private final SalesService salesService;

    @GetMapping("/customer")
    public ResponseEntity readCustomers(){
        return ResponseEntity.ok(salesService.readCustomers());
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> readCustomer(@PathVariable Long id){
        return ResponseEntity.ok(salesService.readCustomer(id));
    }
    @PostMapping("/customer")
    public ResponseEntity createCustomer(@RequestBody CustomerCreationRequest request){
        return ResponseEntity.ok(salesService.createCustomer(request));
    }
    @PostMapping("/insurance")
    public ResponseEntity<List<Insurance>> readInsurances(@RequestBody InsuranceReadsRequest request ){
        return ResponseEntity.ok(salesService.readInsurances(request));
    }
    @PostMapping("/contract")
    public ResponseEntity<Contract> createContract (@RequestBody InsuranceContractRequest request ){
        return ResponseEntity.ok(salesService.createContract(request));
    }
    @GetMapping("/contract/manage")
    public ResponseEntity<List<Contract>> readContracts(){
        return ResponseEntity.ok(salesService.readContracts());
    }
    @PatchMapping("/contract/manage/{contractId}")
    public ResponseEntity<Contract> updateContract (@PathVariable Long contractId, @RequestBody ContractUpdateRequest request ) {
        return ResponseEntity.ok(salesService.updateContract(contractId, request));
    }
    @DeleteMapping("/contract/manage/{contractId}")
    public ResponseEntity<Void> deleteContract (@PathVariable Long contractId) {
        salesService.deleteContract(contractId);
        return ResponseEntity.ok().build();
    }
}

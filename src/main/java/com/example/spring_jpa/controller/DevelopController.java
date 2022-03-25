package com.example.spring_jpa.controller;


import com.example.spring_jpa.entity.Insurance;
import com.example.spring_jpa.request.InsuranceCreationRequest;
import com.example.spring_jpa.service.DevelopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/develop")
@RequiredArgsConstructor
public class DevelopController {
    private final DevelopService developService;

    @GetMapping
    public ResponseEntity<List<Insurance>> readAllInsurances(){
        return ResponseEntity.ok(developService.readAllInsurances());
    }
    @PostMapping("/insurance")
    public ResponseEntity createInsurance(@RequestBody InsuranceCreationRequest request){
            return ResponseEntity.ok(developService.createInsurance(request));
    }
    @DeleteMapping("/insurance/{insuranceId}")
    public ResponseEntity<Void> deleteInsurance( @PathVariable Long insuranceId ){
        developService.deleteInsurance(insuranceId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/insurance/nonapprove")
    public ResponseEntity<List<Insurance>> readInsurances(){
        return ResponseEntity.ok(developService.readInsurances());
    }
    @PatchMapping("/insurance/{insuranceId}")
    public ResponseEntity updateInsurance(@PathVariable Long insuranceId){
        return ResponseEntity.ok(developService.updateInsurance(insuranceId));
    }
}

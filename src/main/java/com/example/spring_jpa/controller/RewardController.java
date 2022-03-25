package com.example.spring_jpa.controller;

import com.example.spring_jpa.entity.Accident;
import com.example.spring_jpa.entity.Reward;
import com.example.spring_jpa.request.AccidentRequest;
import com.example.spring_jpa.request.RewardRequest;
import com.example.spring_jpa.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/reward")
@RequiredArgsConstructor
public class RewardController {
    private final RewardService rewardService;

    @PostMapping("/accident")
    public ResponseEntity createAccident(@RequestBody AccidentRequest request){
        return ResponseEntity.ok(rewardService.createAccident(request));
    }
    @DeleteMapping("/accident/{accidentId}")
    public ResponseEntity<Void> deleteAccident(@PathVariable Long accidentId){
        rewardService.deleteAccident(accidentId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/accident/manage")
    public ResponseEntity<List<Accident>> readAccidents(){
        return ResponseEntity.ok(rewardService.readAccidents());
    }
    @PostMapping("/customer/{customerId}")
    public ResponseEntity<Accident> readAccident(@PathVariable Long customerId){
        return ResponseEntity.ok(rewardService.readAccident(customerId));
    }
    @PostMapping("/reward")
    public ResponseEntity<Reward> createReward (@RequestBody RewardRequest request ){
        return ResponseEntity.ok(rewardService.createReward(request));
    }

}

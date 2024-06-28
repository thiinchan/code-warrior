package com.codewarrior.controller;

import com.codewarrior.model.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChallengeController {

    @Autowired
    private ChallengeRepository challengeRepository;

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    @GetMapping("/challenges/{id}")
    public ResponseEntity<Challenge> getChallengeById(@PathVariable Long id) {
        Challenge challenge = challengeRepository.findById(id).orElse(null);
        return ResponseEntity.ok(challenge);
    }

    @PostMapping("/challenges")
    public ResponseEntity<Challenge> createChallenge(@RequestBody Challenge challenge) {
        Challenge savedChallenge = challengeRepository.save(challenge);
        return ResponseEntity.ok(savedChallenge);
    }
}

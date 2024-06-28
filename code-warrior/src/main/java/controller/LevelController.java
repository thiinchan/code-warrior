package com.codewarrior.controller;

import com.codewarrior.model.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LevelController {

    @Autowired
    private LevelRepository levelRepository;

    @GetMapping("/levels")
    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }

    @GetMapping("/levels/{id}")
    public ResponseEntity<Level> getLevelById(@PathVariable Long id) {
        Level level = levelRepository.findById(id).orElse(null);
        return ResponseEntity.ok(level);
    }

    @PostMapping("/levels")
    public ResponseEntity<Level> createLevel(@RequestBody Level level) {
        Level savedLevel = levelRepository.save(level);
        return ResponseEntity.ok(savedLevel);
    }
}

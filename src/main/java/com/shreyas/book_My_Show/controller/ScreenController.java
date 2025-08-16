package com.shreyas.book_My_Show.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shreyas.book_My_Show.dto.ScreenDTO;
import com.shreyas.book_My_Show.service.ScreenService;

@RestController
@RequestMapping("/screens")
public class ScreenController {
    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @PostMapping
    public ResponseEntity<ScreenDTO> addScreen(@RequestBody ScreenDTO screenDTO) {
        return ResponseEntity.ok(screenService.addScreen(screenDTO));
    }

    @GetMapping
    public ResponseEntity<List<ScreenDTO>> getAllScreens() {
        return ResponseEntity.ok(screenService.getAllScreens());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScreenDTO> getScreenById(@PathVariable Long id) {
        return ResponseEntity.ok(screenService.getScreenById(id));
    }
}

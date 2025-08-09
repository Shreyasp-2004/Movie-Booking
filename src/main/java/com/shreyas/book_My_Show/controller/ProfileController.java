package com.shreyas.book_My_Show.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shreyas.book_My_Show.dto.ProfileDTO;
import com.shreyas.book_My_Show.service.ProfileService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/health")
    public String getMethodName() {
        return "runnnig";
    }
    

    @PostMapping("/register")
    public ResponseEntity<ProfileDTO> registerUser(@RequestBody ProfileDTO profileDTO) {
        ProfileDTO registeredUser = profileService.registerUser(profileDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    } 
}

package com.akshay.projects.lovable.controllers;

import com.akshay.projects.lovable.DTO.auth.AuthResponse;
import com.akshay.projects.lovable.DTO.auth.LoginRequest;
import com.akshay.projects.lovable.DTO.auth.SignupRequest;
import com.akshay.projects.lovable.DTO.auth.UserProfileResponse;
import com.akshay.projects.lovable.service.AuthService;
import com.akshay.projects.lovable.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signups(SignupRequest request){
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));

    }

}


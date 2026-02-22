package com.akshay.projects.lovable.controllers;

import com.akshay.projects.lovable.DTO.auth.AuthResponse;
import com.akshay.projects.lovable.DTO.auth.LoginRequest;
import com.akshay.projects.lovable.DTO.auth.SignupRequest;
import com.akshay.projects.lovable.DTO.auth.UserProfileResponse;
import com.akshay.projects.lovable.service.AuthService;
import com.akshay.projects.lovable.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {

     AuthService authService;
     UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signups(@RequestBody SignupRequest request){
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));

    }

}


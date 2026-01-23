package com.akshay.projects.lovable.service;

import com.akshay.projects.lovable.DTO.auth.AuthResponse;
import com.akshay.projects.lovable.DTO.auth.LoginRequest;
import com.akshay.projects.lovable.DTO.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest request);
    AuthResponse login(LoginRequest request);
}

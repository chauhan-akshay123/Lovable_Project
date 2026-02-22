package com.akshay.projects.lovable.service.impl;

import com.akshay.projects.lovable.DTO.auth.AuthResponse;
import com.akshay.projects.lovable.DTO.auth.LoginRequest;
import com.akshay.projects.lovable.DTO.auth.SignupRequest;
import com.akshay.projects.lovable.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceimpl implements AuthService {

    @Override
    public AuthResponse signup(SignupRequest request){
        return null;
    }

    @Override
   public AuthResponse login(LoginRequest request){
        return null;
    }
}

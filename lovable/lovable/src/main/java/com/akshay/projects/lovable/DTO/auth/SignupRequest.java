package com.akshay.projects.lovable.DTO.auth;

public record SignupRequest(
        String email,
        String name,
        String password
) {
}

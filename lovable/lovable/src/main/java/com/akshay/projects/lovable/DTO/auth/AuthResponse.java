package com.akshay.projects.lovable.DTO.auth;

public record AuthResponse(
   String token,
   UserProfileResponse user
) {
}

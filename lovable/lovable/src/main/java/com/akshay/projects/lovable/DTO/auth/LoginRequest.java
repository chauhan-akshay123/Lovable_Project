package com.akshay.projects.lovable.DTO.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
   @Email @NotBlank String username,
   @NotBlank @Size(min = 4, max = 30) String password
) {
}

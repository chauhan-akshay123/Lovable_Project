package com.akshay.projects.lovable.DTO.project;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(
   @NotBlank String name
) {
}

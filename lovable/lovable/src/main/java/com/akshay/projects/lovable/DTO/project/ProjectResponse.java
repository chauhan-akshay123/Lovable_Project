package com.akshay.projects.lovable.DTO.project;

import com.akshay.projects.lovable.DTO.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner
) {
}

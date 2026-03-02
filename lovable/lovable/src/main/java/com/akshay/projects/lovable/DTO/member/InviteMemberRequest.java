package com.akshay.projects.lovable.DTO.member;

import com.akshay.projects.lovable.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
        @Email @NotNull @NotBlank String email,
        @NotNull ProjectRole role
) {
}

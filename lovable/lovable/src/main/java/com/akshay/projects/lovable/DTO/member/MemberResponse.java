package com.akshay.projects.lovable.DTO.member;

import com.akshay.projects.lovable.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
     Long userId,
     String username,
     String name,
     ProjectRole projectRole,
     Instant invitedAt
) {
}

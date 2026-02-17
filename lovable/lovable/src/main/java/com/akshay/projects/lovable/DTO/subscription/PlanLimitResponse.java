package com.akshay.projects.lovable.DTO.subscription;

public record PlanLimitResponse(
        String planName,
        int maxTokensPerDay,
        int maxProjects,
        boolean unlimitedAi
) {
}

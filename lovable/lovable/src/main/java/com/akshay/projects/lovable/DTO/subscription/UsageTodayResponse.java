package com.akshay.projects.lovable.DTO.subscription;

public record UsageTodayResponse(
        int tokensUsed,
        int tokensLimit,
        int previewsRemaining,
        int previewsLimit
) {
}

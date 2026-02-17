package com.akshay.projects.lovable.DTO.subscription;

public record UsageTodayResponse(
        Integer  tokensUsed,
        Integer tokensLimit,
        Integer previewsRemaining,
        Integer previewsLimit
) {
}

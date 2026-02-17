package com.akshay.projects.lovable.service;

import com.akshay.projects.lovable.DTO.subscription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);
}

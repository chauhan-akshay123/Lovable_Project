package com.akshay.projects.lovable.service;

import com.akshay.projects.lovable.DTO.subscription.PlanLimitResponse;
import com.akshay.projects.lovable.DTO.subscription.UsageTodayResponse;

public interface UsageService {
     PlanLimitResponse getCurrentSubscriptionLimitsOfUser(Long userId);
     UsageTodayResponse getTodayUsageOfUser(Long userId);
}

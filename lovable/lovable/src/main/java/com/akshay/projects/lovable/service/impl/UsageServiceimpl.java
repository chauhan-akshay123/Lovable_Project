package com.akshay.projects.lovable.service.impl;

import com.akshay.projects.lovable.DTO.subscription.PlanLimitResponse;
import com.akshay.projects.lovable.DTO.subscription.UsageTodayResponse;
import com.akshay.projects.lovable.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceimpl implements UsageService {

    @Override
    public PlanLimitResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }

    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }
}

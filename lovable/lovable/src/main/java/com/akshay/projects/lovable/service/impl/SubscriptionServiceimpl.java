package com.akshay.projects.lovable.service.impl;

import com.akshay.projects.lovable.DTO.subscription.SubscriptionResponse;
import com.akshay.projects.lovable.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceimpl implements SubscriptionService {

    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

}

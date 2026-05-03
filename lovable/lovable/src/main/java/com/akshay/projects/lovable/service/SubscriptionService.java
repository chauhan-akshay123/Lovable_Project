package com.akshay.projects.lovable.service;

import com.akshay.projects.lovable.DTO.subscription.SubscriptionResponse;

public interface SubscriptionService {

    SubscriptionResponse getCurrentSubscription(Long userId);

}

package com.akshay.projects.lovable.service.impl;

import com.akshay.projects.lovable.DTO.subscription.CheckoutRequest;
import com.akshay.projects.lovable.DTO.subscription.CheckoutResponse;
import com.akshay.projects.lovable.DTO.subscription.PortalResponse;
import com.akshay.projects.lovable.DTO.subscription.SubscriptionResponse;
import com.akshay.projects.lovable.service.SubscriptionService;

public class SubscriptionServiceimpl implements SubscriptionService {

    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createChekoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}

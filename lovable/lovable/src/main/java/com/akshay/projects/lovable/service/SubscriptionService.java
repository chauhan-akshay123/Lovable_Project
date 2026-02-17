package com.akshay.projects.lovable.service;

import com.akshay.projects.lovable.DTO.subscription.CheckoutRequest;
import com.akshay.projects.lovable.DTO.subscription.CheckoutResponse;
import com.akshay.projects.lovable.DTO.subscription.PortalResponse;
import com.akshay.projects.lovable.DTO.subscription.SubscriptionResponse;

public interface SubscriptionService {

    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createChekoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);

}

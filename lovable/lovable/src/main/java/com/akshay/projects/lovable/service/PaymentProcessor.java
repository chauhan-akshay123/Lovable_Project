package com.akshay.projects.lovable.service;

import com.akshay.projects.lovable.DTO.subscription.CheckoutRequest;
import com.akshay.projects.lovable.DTO.subscription.CheckoutResponse;
import com.akshay.projects.lovable.DTO.subscription.PortalResponse;

public interface PaymentProcessor {

    CheckoutResponse createChekoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal(Long userId);

}

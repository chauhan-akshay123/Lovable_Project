package com.akshay.projects.lovable.service;

import com.akshay.projects.lovable.DTO.subscription.CheckoutRequest;
import com.akshay.projects.lovable.DTO.subscription.CheckoutResponse;
import com.akshay.projects.lovable.DTO.subscription.PortalResponse;
import com.stripe.model.StripeObject;

import java.util.Map;

public interface PaymentProcessor {

    CheckoutResponse createChekoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal();

    void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);
}

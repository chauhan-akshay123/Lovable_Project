package com.akshay.projects.lovable.service.impl;

import com.akshay.projects.lovable.DTO.subscription.CheckoutRequest;
import com.akshay.projects.lovable.DTO.subscription.CheckoutResponse;
import com.akshay.projects.lovable.DTO.subscription.PortalResponse;
import com.akshay.projects.lovable.entity.Plan;
import com.akshay.projects.lovable.error.ResourceNotFoundException;
import com.akshay.projects.lovable.repository.PlanRepository;
import com.akshay.projects.lovable.security.AuthUtil;
import com.akshay.projects.lovable.service.PaymentProcessor;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StripePaymentProcessor implements PaymentProcessor {

    private final AuthUtil authUtil;
    private final PlanRepository planRepository;

    @Value("${client.url}")
    private String frontendUrl;

    @Override
    public CheckoutResponse createChekoutSessionUrl(CheckoutRequest request) {
        Plan plan = planRepository.findById(request.planId()).orElseThrow(() -> new ResourceNotFoundException("Plan", request.planId().toString()));
        Long userId = authUtil.getCurrentUserId();

        SessionCreateParams params = SessionCreateParams.builder()
                .addLineItem(
                        SessionCreateParams.LineItem.builder()
                                .setPrice(plan.getStripePriceId())
                                .setQuantity(1L)
                                .build()
                )
                .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
                .setSubscriptionData(
                        SessionCreateParams.SubscriptionData.builder()
                                .setBillingMode(
                                        SessionCreateParams.SubscriptionData.BillingMode.builder()
                                                .setType(SessionCreateParams.SubscriptionData.BillingMode.Type.FLEXIBLE)
                                                .build()
                                )
                                .build()
                )
                .setSuccessUrl(frontendUrl + "/success.html?session_id={CHECKOUT_SESSION_ID}")
                .setCancelUrl(frontendUrl + "/cancel.html")
                .putMetadata("user_id", userId.toString())
                .putMetadata("plan_id", plan.getId().toString())
                .build();

        try{
            Session session = Session.create(params); // making api call to the stripe backend
            return new CheckoutResponse(session.getUrl());
        } catch (StripeException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}

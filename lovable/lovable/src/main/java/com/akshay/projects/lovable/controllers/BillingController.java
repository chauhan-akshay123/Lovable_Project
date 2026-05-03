package com.akshay.projects.lovable.controllers;

import com.akshay.projects.lovable.DTO.subscription.*;
import com.akshay.projects.lovable.service.PaymentProcessor;
import com.akshay.projects.lovable.service.PlanService;
import com.akshay.projects.lovable.service.SubscriptionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping()
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BillingController {

    PlanService planService;
    SubscriptionService subscriptionService;
    PaymentProcessor paymentProcessor;

    @GetMapping("/api/plans")
    public ResponseEntity<List<PlanResponse>> getAllPlans(){
        return ResponseEntity.ok(planService.getAllActivePlans());
    }

    @GetMapping("/api/me/subscription")
    public ResponseEntity<SubscriptionResponse> getMySubscription(){
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.getCurrentSubscription(userId));
    }

    @PostMapping("/api/payments/checkout")
    public ResponseEntity<CheckoutResponse> createCheckoutResponse(
            @RequestBody CheckoutRequest request
    ){
        return ResponseEntity.ok(paymentProcessor.createChekoutSessionUrl(request));
    }

    @PostMapping("/api/payments/portal")
    public ResponseEntity<PortalResponse> openCustomerPortal(){
        Long userId = 1L;
        return ResponseEntity.ok(paymentProcessor.openCustomerPortal(userId));
    }
}

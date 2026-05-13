package com.akshay.projects.lovable.service;

import com.akshay.projects.lovable.DTO.subscription.SubscriptionResponse;
import com.akshay.projects.lovable.enums.SubscriptionStatus;

import java.time.Instant;

public interface SubscriptionService {

    SubscriptionResponse getCurrentSubscription();

    void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId);

    void updateSubscription(String gatewaySubscriptionId, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId);

    void cancelSubscription(String gatewaySubscriptionId);

    void renewSubscriptionPeriod(String gatewaySubscriptionId, Instant periodStart, Instant periodEnd);

    void markSubscriptionPastDue(String gatewaySubscriptionId);
}

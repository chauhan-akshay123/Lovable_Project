package com.akshay.projects.lovable.mapper;

import com.akshay.projects.lovable.DTO.subscription.PlanResponse;
import com.akshay.projects.lovable.DTO.subscription.SubscriptionResponse;
import com.akshay.projects.lovable.entity.Plan;
import com.akshay.projects.lovable.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanResponse toPlanResponse(Plan plan);
}

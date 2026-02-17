package com.akshay.projects.lovable.service;

import com.akshay.projects.lovable.DTO.subscription.PlanResponse;

import java.util.List;

public interface PlanService {

    List<PlanResponse> getAllActivePlans();

}

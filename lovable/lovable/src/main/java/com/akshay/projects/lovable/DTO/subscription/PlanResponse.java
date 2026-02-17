package com.akshay.projects.lovable.DTO.subscription;

public record PlanResponse(
     Long id,
     String name,
     Integer maxProjects,
     Integer maxTokensPerDay,
     Boolean unlimited,
     String price
){
}

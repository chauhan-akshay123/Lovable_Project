package com.akshay.projects.lovable.service;

import com.akshay.projects.lovable.DTO.auth.UserProfileResponse;

public interface UserService {
   UserProfileResponse getProfile(Long userId);
}

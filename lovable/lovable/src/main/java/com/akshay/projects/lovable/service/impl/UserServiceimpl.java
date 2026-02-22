package com.akshay.projects.lovable.service.impl;

import com.akshay.projects.lovable.DTO.auth.UserProfileResponse;
import com.akshay.projects.lovable.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {

    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}

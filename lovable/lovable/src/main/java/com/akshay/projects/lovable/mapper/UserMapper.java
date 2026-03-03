package com.akshay.projects.lovable.mapper;

import com.akshay.projects.lovable.DTO.auth.SignupRequest;
import com.akshay.projects.lovable.DTO.auth.UserProfileResponse;
import com.akshay.projects.lovable.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);
}

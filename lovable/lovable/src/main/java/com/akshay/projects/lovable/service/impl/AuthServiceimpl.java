package com.akshay.projects.lovable.service.impl;

import com.akshay.projects.lovable.DTO.auth.AuthResponse;
import com.akshay.projects.lovable.DTO.auth.LoginRequest;
import com.akshay.projects.lovable.DTO.auth.SignupRequest;
import com.akshay.projects.lovable.entity.User;
import com.akshay.projects.lovable.error.BadRequestException;
import com.akshay.projects.lovable.mapper.UserMapper;
import com.akshay.projects.lovable.repository.UserRepository;
import com.akshay.projects.lovable.security.AuthUtil;
import com.akshay.projects.lovable.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceimpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    AuthUtil authUtil;
    AuthenticationManager authenticationManager;


    @Override
    public AuthResponse signup(SignupRequest request){
        userRepository.findByUsername(request.username())
                .ifPresent(user ->{
                throw new BadRequestException("User already exists with username: " + request.username());
                });

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);

        String token = authUtil.generateAccessToken(user);
        return new AuthResponse("dummy", userMapper.toUserProfileResponse(user));
    }

    @Override
   public AuthResponse login(LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        User user = (User) authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);
        return new AuthResponse(token, userMapper.toUserProfileResponse(user));
    }
}

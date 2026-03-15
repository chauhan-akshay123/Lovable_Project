package com.akshay.projects.lovable.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtUserPrincipal {
    Long userId;
    String username;
    List<GrantedAuthority> authorities;
}

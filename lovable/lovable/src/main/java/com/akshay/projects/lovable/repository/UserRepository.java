package com.akshay.projects.lovable.repository;

import com.akshay.projects.lovable.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

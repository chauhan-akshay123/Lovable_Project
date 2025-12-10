package com.akshay.projects.lovable.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
public class User {

     Long id;
     String email;
     String passwordHash;
     String name;

     String avatarUrl;
     Instant createdAt;
     Instant updatedAt;
     Instant deletedAt;
}

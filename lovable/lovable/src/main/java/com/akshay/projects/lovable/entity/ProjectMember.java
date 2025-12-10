package com.akshay.projects.lovable.entity;

import com.akshay.projects.lovable.enums.ProjectRole;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ProjectMember {

   ProjectMemberId id;

   Project project;

   User user;

   ProjectRole projectRole;

   Instant invitedAt;

}

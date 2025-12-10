package com.akshay.projects.lovable.entity;


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
public class ProjectFile {
  Long id;

  Project project;

  String path;

  String minioObjectKey;

  Instant createdAt;

  Instant updatedAt;

  User createdBy;

  User updatedBy;

}

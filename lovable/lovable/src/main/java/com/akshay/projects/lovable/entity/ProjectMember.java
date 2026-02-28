package com.akshay.projects.lovable.entity;

import com.akshay.projects.lovable.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "project_members")
public class ProjectMember {

   @EmbeddedId
   ProjectMemberId id; // (composite Key)

   @ManyToOne
   @MapsId("projectId")
   Project project;

   @ManyToOne
   @MapsId("userId")
   User user;

   ProjectRole projectRole;

   Instant invitedAt;
   Instant acceptedAt;
}

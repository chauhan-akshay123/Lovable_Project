package com.akshay.projects.lovable.entity;

import com.akshay.projects.lovable.enums.MessageRole;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {

  Long id;
  ChatSession chatSession;

  String content;

  MessageRole role;

  String totalCalls;

  Integer tokensUsed;

  Instant createdAt;

}

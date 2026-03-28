package com.sachin.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackResponse {
    private String message;
    private Integer rating;
    private LocalDateTime createdAt;
}
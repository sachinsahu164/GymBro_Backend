package com.sachin.service;

import com.sachin.SecurityRoom.repository.UserRepository;
import com.sachin.dto.FeedbackRequest;
import com.sachin.dto.FeedbackResponse;
import com.sachin.entity.Feedback;
import com.sachin.SecurityRoom.entity.user_auth;
import com.sachin.repository.FeedbackRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;

    private user_auth getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void submitFeedback(FeedbackRequest request) {
        user_auth user = getCurrentUser();

        Feedback feedback = Feedback.builder()
                .userAuth(user)
                .message(request.getMessage())
                .rating(request.getRating())
                .createdAt(LocalDateTime.now())
                .build();

        feedbackRepository.save(feedback);
    }

    @Override
    public List<FeedbackResponse> getUserFeedbacks() {
        user_auth user = getCurrentUser();

        return feedbackRepository.findByUserAuth(user).stream()
                .map(f -> FeedbackResponse.builder()
                        .message(f.getMessage())
                        .rating(f.getRating())
                        .createdAt(f.getCreatedAt())
                        .build())
                .toList();
    }
}
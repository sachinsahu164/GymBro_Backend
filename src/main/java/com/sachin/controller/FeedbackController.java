package com.sachin.controller;



import com.sachin.dto.FeedbackRequest;
import com.sachin.dto.FeedbackResponse;
import com.sachin.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping
    public String submitFeedback(@RequestBody FeedbackRequest request) {
        feedbackService.submitFeedback(request);
        return "Feedback submitted successfully";
    }

    @GetMapping
    public List<FeedbackResponse> getUserFeedbacks() {
        return feedbackService.getUserFeedbacks();
    }
}

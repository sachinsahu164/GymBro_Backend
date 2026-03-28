package com.sachin.service;


import com.sachin.dto.FeedbackRequest;
import com.sachin.dto.FeedbackResponse;

import java.util.List;

public interface FeedbackService {
    void submitFeedback(FeedbackRequest request);
    List<FeedbackResponse> getUserFeedbacks();
}

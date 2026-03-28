package com.sachin.repository;

import com.sachin.entity.Feedback;
import com.sachin.SecurityRoom.entity.user_auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByUserAuth(user_auth userAuth);
}
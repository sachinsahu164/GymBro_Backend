package com.sachin.entity;
import com.sachin.SecurityRoom.entity.user_auth;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private user_auth userAuth;

    private String message;       // User feedback text
    private Integer rating;       // Optional: 1-5 stars
    private LocalDateTime createdAt;
}

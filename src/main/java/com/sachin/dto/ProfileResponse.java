package com.sachin.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileResponse {
    private Long id;
    private String username;
    private Integer age;
    private String gender;
    private Double height;
    private Double weight;
    private String goal;
    private String activityLevel;
}
package com.sachin.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRequest {
    private Long id;
    private String username;
    private Integer age;
    private String gender;
    private Double height;
    private Double weight;
    private String goal;
    private String activityLevel;
}

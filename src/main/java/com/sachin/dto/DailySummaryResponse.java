package com.sachin.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailySummaryResponse {

    private int totalCalories;
    private int targetCalories;
    private int remainingCalories;

    private int protein;
    private int carbs;
    private int fat;
}
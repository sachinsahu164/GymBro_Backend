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
    private int targetProtein;

    private int carbs;
    private int targetCarbs;

    private int fat;
    private int targetFat;
}
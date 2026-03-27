package com.sachin.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealResponse {

    private String foodName;
    private String mealType;
    private double quantity;

    private int calories;
    private int protein;
    private int carbs;
    private int fat;
}
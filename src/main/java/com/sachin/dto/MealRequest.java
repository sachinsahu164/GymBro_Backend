package com.sachin.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealRequest {

    private Long foodItemId;   // selected food
    private String mealType;   // BREAKFAST / LUNCH / DINNER / SNACK
    private double quantity;   // 1, 2, 0.5 etc
}
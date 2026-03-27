package com.sachin.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealGroupRequest {

    private String mealType; // BREAKFAST / LUNCH / DINNER / SNACK
    private List<MealItem> items;
}
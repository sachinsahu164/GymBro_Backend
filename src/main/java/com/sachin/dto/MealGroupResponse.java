package com.sachin.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealGroupResponse {

    private List<MealResponse> meals;
    private DailySummaryResponse summary;
}
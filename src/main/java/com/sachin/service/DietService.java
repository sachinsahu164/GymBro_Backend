package com.sachin.service;

import com.sachin.dto.*;

import java.util.List;

public interface DietService {

    // Add new meal
    MealResponse addMeal(MealRequest request);

    // Get today's meals
    List<MealResponse> getTodayMeals();

    // Get daily summary (calories + macros)
    DailySummaryResponse getDailySummary();

    MealGroupResponse addMealGroup(MealGroupRequest request);
}
package com.sachin.controller;

import com.sachin.dto.*;
import com.sachin.entity.diet.FoodItem;
import com.sachin.repository.FoodItemRepository;
import com.sachin.service.DietService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diet")
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;
    private final FoodItemRepository foodItemRepository;

    // ✅ 1. Get food list (dropdown ke liye)
    @GetMapping("/foods")
    public List<FoodItem> getFoods(@RequestParam String category) {
        return foodItemRepository.findByCategory(category);
    }

    // ✅ 2. Add meal (🔥 no userId needed)
    @PostMapping("/meals")
    public MealResponse addMeal(@RequestBody MealRequest request) {
        return dietService.addMeal(request);
    }

    // ✅ 3. Get today's meals
    @GetMapping("/meals")
    public List<MealResponse> getTodayMeals() {
        return dietService.getTodayMeals();
    }

    // ✅ 4. Get daily summary
    @GetMapping("/summary")
    public DailySummaryResponse getSummary() {
        return dietService.getDailySummary();
    }


    @PostMapping("/meal-group")
    public MealGroupResponse addMealGroup(@RequestBody MealGroupRequest request) {
        return dietService.addMealGroup(request);
    }

}
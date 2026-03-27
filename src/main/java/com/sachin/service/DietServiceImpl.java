package com.sachin.service;

import com.sachin.SecurityRoom.entity.user_auth;
import com.sachin.SecurityRoom.repository.UserRepository;
import com.sachin.dto.*;

import com.sachin.entity.diet.FoodItem;
import com.sachin.entity.diet.MealEntry;
import com.sachin.repository.FoodItemRepository;
import com.sachin.repository.MealEntryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DietServiceImpl implements DietService {

    private final FoodItemRepository foodItemRepository;
    private final MealEntryRepository mealEntryRepository;
    private final UserRepository userRepository;

    // 🔥 Get userId from JWT (email → DB → userId)
    private Long getCurrentUserId() {

        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        user_auth user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getId();
    }

    // ✅ 1. ADD MEAL
    @Override
    public MealResponse addMeal(MealRequest request) {

        Long userId = getCurrentUserId();

        FoodItem foodItem = foodItemRepository.findById(request.getFoodItemId())
                .orElseThrow(() -> new RuntimeException("Food not found"));

        double qty = request.getQuantity();

        int totalCalories = (int) (foodItem.getCaloriesPerUnit() * qty);
        int totalProtein = (int) (foodItem.getProteinPerUnit() * qty);
        int totalCarbs = (int) (foodItem.getCarbsPerUnit() * qty);
        int totalFat = (int) (foodItem.getFatPerUnit() * qty);

        MealEntry meal = MealEntry.builder()
                .userId(userId)
                .foodItem(foodItem)
                .mealType(request.getMealType())
                .quantity(qty)
                .totalCalories(totalCalories)
                .totalProtein(totalProtein)
                .totalCarbs(totalCarbs)
                .totalFat(totalFat)
                .date(LocalDate.now())
                .build();

        mealEntryRepository.save(meal);

        return mapToResponse(meal);
    }

    // ✅ 2. GET TODAY MEALS
    @Override
    public List<MealResponse> getTodayMeals() {

        Long userId = getCurrentUserId();

        return mealEntryRepository
                .findByUserIdAndDate(userId, LocalDate.now())
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // ✅ 3. DAILY SUMMARY
    @Override
    public DailySummaryResponse getDailySummary() {

        Long userId = getCurrentUserId();

        List<MealEntry> meals = mealEntryRepository
                .findByUserIdAndDate(userId, LocalDate.now());

        int totalCalories = meals.stream().mapToInt(MealEntry::getTotalCalories).sum();
        int totalProtein = meals.stream().mapToInt(MealEntry::getTotalProtein).sum();
        int totalCarbs = meals.stream().mapToInt(MealEntry::getTotalCarbs).sum();
        int totalFat = meals.stream().mapToInt(MealEntry::getTotalFat).sum();

        int targetCalories = 3000;

        return DailySummaryResponse.builder()
                .totalCalories(totalCalories)
                .targetCalories(targetCalories)
                .remainingCalories(targetCalories - totalCalories)
                .protein(totalProtein)
                .carbs(totalCarbs)
                .fat(totalFat)
                .build();
    }

    // 🔥 Common mapper (clean code)
    private MealResponse mapToResponse(MealEntry meal) {
        return MealResponse.builder()
                .foodName(meal.getFoodItem().getName())
                .mealType(meal.getMealType())
                .quantity(meal.getQuantity())
                .calories(meal.getTotalCalories())
                .protein(meal.getTotalProtein())
                .carbs(meal.getTotalCarbs())
                .fat(meal.getTotalFat())
                .build();
    }
    @Override
    public MealGroupResponse addMealGroup(MealGroupRequest request) {

        Long userId = getCurrentUserId();

        List<MealResponse> responses = request.getItems().stream().map(item -> {

            FoodItem foodItem = foodItemRepository.findById(item.getFoodItemId())
                    .orElseThrow(() -> new RuntimeException("Food not found"));

            double qty = item.getQuantity();

            int totalCalories = (int) (foodItem.getCaloriesPerUnit() * qty);
            int totalProtein = (int) (foodItem.getProteinPerUnit() * qty);
            int totalCarbs = (int) (foodItem.getCarbsPerUnit() * qty);
            int totalFat = (int) (foodItem.getFatPerUnit() * qty);

            MealEntry meal = MealEntry.builder()
                    .userId(userId)
                    .foodItem(foodItem)
                    .mealType(request.getMealType())
                    .quantity(qty)
                    .totalCalories(totalCalories)
                    .totalProtein(totalProtein)
                    .totalCarbs(totalCarbs)
                    .totalFat(totalFat)
                    .date(LocalDate.now())
                    .build();

            mealEntryRepository.save(meal);

            return mapToResponse(meal);

        }).toList();

        // 🔥 AFTER SAVE → calculate summary
        List<MealEntry> allMeals = mealEntryRepository
                .findByUserIdAndDate(userId, LocalDate.now());

        int totalCalories = allMeals.stream().mapToInt(MealEntry::getTotalCalories).sum();
        int totalProtein = allMeals.stream().mapToInt(MealEntry::getTotalProtein).sum();
        int totalCarbs = allMeals.stream().mapToInt(MealEntry::getTotalCarbs).sum();
        int totalFat = allMeals.stream().mapToInt(MealEntry::getTotalFat).sum();

        int targetCalories = 3000;

        DailySummaryResponse summary = DailySummaryResponse.builder()
                .totalCalories(totalCalories)
                .targetCalories(targetCalories)
                .remainingCalories(targetCalories - totalCalories)
                .protein(totalProtein)
                .carbs(totalCarbs)
                .fat(totalFat)
                .build();

        return MealGroupResponse.builder()
                .meals(responses)
                .summary(summary)
                .build();
    }
}
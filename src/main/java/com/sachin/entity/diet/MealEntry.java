package com.sachin.entity.diet;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "meal_entries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User ID (simple approach for now)
    @Column(nullable = false)
    private Long userId;

    // Food reference
    @ManyToOne
    @JoinColumn(name = "food_item_id", nullable = false)
    private FoodItem foodItem;

    // Meal type (BREAKFAST, LUNCH, DINNER, SNACK)
    @Column(nullable = false)
    private String mealType;

    // Quantity (1 plate, 2 pieces etc)
    @Column(nullable = false)
    private double quantity;

    // Calculated values (IMPORTANT)
    private int totalCalories;
    private int totalProtein;
    private int totalCarbs;
    private int totalFat;

    // Date of meal
    @Column(nullable = false)
    private LocalDate date;
}
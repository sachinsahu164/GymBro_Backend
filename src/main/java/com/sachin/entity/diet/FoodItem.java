package com.sachin.entity.diet;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "food_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Food name (Poha, Rice, Egg, Chips)
    @Column(nullable = false)
    private String name;

    // Meal category (BREAKFAST, LUNCH, DINNER, SNACK)
    @Column(nullable = false)
    private String category;

    // Calories per unit (e.g. 1 plate = 250 kcal)
    @Column(nullable = false)
    private int caloriesPerUnit;

    // Protein in grams
    @Column(nullable = false)
    private int proteinPerUnit;

    // Carbs in grams
    @Column(nullable = false)
    private int carbsPerUnit;

    // Fat in grams
    @Column(nullable = false)
    private int fatPerUnit;

    // Unit description (1 plate, 1 piece, 100g)
    @Column(nullable = false)
    private String unit;
}
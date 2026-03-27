package com.sachin.repository;


import com.sachin.entity.diet.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

    // Meal type ke according food fetch karne ke liye
    List<FoodItem> findByCategory(String category);
}
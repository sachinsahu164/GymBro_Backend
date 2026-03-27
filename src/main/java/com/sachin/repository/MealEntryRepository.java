package com.sachin.repository;



import com.sachin.entity.diet.MealEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MealEntryRepository extends JpaRepository<MealEntry, Long> {

    // Aaj ke meals fetch karne ke liye
    List<MealEntry> findByUserIdAndDate(Long userId, LocalDate date);
}
package com.sachin.controller;

import com.sachin.entity.Exercise;
import com.sachin.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/workout")
@RequiredArgsConstructor
public class WorkoutController {

    private final ExerciseService exerciseService;

    @GetMapping("/today")
    public List<Exercise> getTodayWorkout(
            @RequestParam String muscle) {

        return exerciseService.generateWorkout(muscle);
    }
}

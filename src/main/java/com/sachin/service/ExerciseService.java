package com.sachin.service;

import com.sachin.entity.Exercise;
import com.sachin.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public List<Exercise> getExercisesByMuscle(String muscleGroup) {
        return exerciseRepository.findByMuscleGroup(muscleGroup);
    }
    public List<Exercise> generateWorkout(String muscleGroup) {

        List<Exercise> exercises =
                exerciseRepository.findByMuscleGroup(muscleGroup);

        Collections.shuffle(exercises);

        return exercises.stream()
                .limit(6)
                .toList();
    }
}
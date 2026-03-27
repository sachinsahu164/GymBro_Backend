package com.sachin.repository;

import com.sachin.entity.WorkoutSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutScheduleRepository extends JpaRepository<WorkoutSchedule, Long> {

    List<WorkoutSchedule> findByUserId(Long userId);

}

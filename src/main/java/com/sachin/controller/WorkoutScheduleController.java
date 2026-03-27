package com.sachin.controller;

import com.sachin.entity.WorkoutSchedule;
import com.sachin.service.WorkoutScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class WorkoutScheduleController {

    private final WorkoutScheduleService service;

    @GetMapping
    public List<WorkoutSchedule> getSchedule(@RequestParam Long userId) {
        return service.getSchedule(userId);
    }

    @PostMapping
    public WorkoutSchedule updateSchedule(@RequestBody WorkoutSchedule schedule) {
        return service.updateSchedule(schedule);
    }
}
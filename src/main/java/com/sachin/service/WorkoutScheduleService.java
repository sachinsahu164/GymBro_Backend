package com.sachin.service;

import com.sachin.entity.WorkoutSchedule;
import com.sachin.repository.WorkoutScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkoutScheduleService {

    private final WorkoutScheduleRepository repository;

    public List<WorkoutSchedule> getSchedule(Long userId){

        List<WorkoutSchedule> schedule = repository.findByUserId(userId);

        // agar schedule nahi hai to default schedule create karo
        if(schedule.isEmpty()){
            schedule = createDefaultSchedule(userId);
        }

        return schedule;
    }

    public WorkoutSchedule updateSchedule(WorkoutSchedule schedule){

        WorkoutSchedule existing =
                repository.findById(schedule.getId())
                        .orElseThrow(() -> new RuntimeException("Schedule not found"));

        existing.setMuscle(schedule.getMuscle());

        return repository.save(existing);
    }

    private List<WorkoutSchedule> createDefaultSchedule(Long userId){

        List<WorkoutSchedule> list = new ArrayList<>();

        list.add(new WorkoutSchedule(null, userId, "Monday", "CHEST"));
        list.add(new WorkoutSchedule(null, userId, "Tuesday", "BACK"));
        list.add(new WorkoutSchedule(null, userId, "Wednesday", "LEGS"));
        list.add(new WorkoutSchedule(null, userId, "Thursday", "SHOULDERS"));
        list.add(new WorkoutSchedule(null, userId, "Friday", "ARMS"));
        list.add(new WorkoutSchedule(null, userId, "Saturday", "ABS"));
        list.add(new WorkoutSchedule(null, userId, "Sunday", "REST"));

        return repository.saveAll(list);
    }
}
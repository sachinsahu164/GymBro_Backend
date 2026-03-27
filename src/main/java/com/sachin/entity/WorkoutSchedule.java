package com.sachin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "workout_schedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String day;      // MONDAY, TUESDAY...

    private String muscle;   // CHEST, BACK, LEGS
}

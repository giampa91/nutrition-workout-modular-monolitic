package com.nutrition.workout.workoutexecutionservice.DTOs;

import java.time.LocalDateTime;

public class ExerciseLogDTO {

    private Long exerciseId;  // Reference to the exercise
    private Integer repetitions;  // Number of repetitions performed
    private Integer sets;  // Number of sets performed
    private LocalDateTime executionTime;  // Time when exercise was performed

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(LocalDateTime executionTime) {
        this.executionTime = executionTime;
    }
}

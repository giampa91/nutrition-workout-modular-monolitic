package com.nutrition.workout.workoutexecutionservice.DTOs;

import com.nutrition.workout.workoutexecutionservice.domain.ExerciseLog;

import java.util.List;

public class SessionLogDTO {

    private Long id;
    private String name;
    private List<ExerciseLog> exercises; // List of exercises in this session
    private Long createdAt;
    private Long updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ExerciseLog> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseLog> exercises) {
        this.exercises = exercises;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}


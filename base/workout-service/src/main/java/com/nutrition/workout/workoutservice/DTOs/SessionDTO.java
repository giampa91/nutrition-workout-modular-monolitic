package com.nutrition.workout.workoutservice.DTOs;

import com.nutrition.workout.workoutservice.domain.Exercise;

import java.util.List;

public class SessionDTO {

    private Long id;
    private String name;
    private String description;
    private List<ExerciseDTO> exercises; // List of exercises in this session
    private Long createdAt;
    private Long updatedAt;

    // Constructor, Getters, Setters
    public SessionDTO(Long id, String name, String description, List<ExerciseDTO> exercises) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.exercises = exercises;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ExerciseDTO> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseDTO> exercises) {
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

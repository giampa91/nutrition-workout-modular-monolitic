package com.nutrition.workout.workoutservice.DTOs;

import com.nutrition.workout.workoutservice.domain.Exercise;

import java.util.List;

public class WorkoutProgramDTO {

    private Long id;
    private String name;
    private String description;
    private UserDTO pt; // Assuming PersonalTrainer is another class
    private List<UserDTO> assignedUsers; // List of users assigned to this workout
    private List<SessionDTO> sessions; // List of exercises in this program
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDTO getPt() {
        return pt;
    }

    public void setPt(UserDTO pt) {
        this.pt = pt;
    }

    public List<UserDTO> getAssignedUsers() {
        return assignedUsers;
    }

    public void setAssignedUsers(List<UserDTO> assignedUsers) {
        this.assignedUsers = assignedUsers;
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

    public List<SessionDTO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDTO> sessions) {
        this.sessions = sessions;
    }
}


package com.nutrition.workout.workoutexecutionservice.DTOs;

import com.nutrition.workout.workoutexecutionservice.domain.ExerciseLog;
import com.nutrition.workout.workoutexecutionservice.domain.SessionLog;

import java.time.LocalDateTime;
import java.util.List;

public class WorkoutExecutionDTO {

    private Long id;
    private Long userId;  // Reference to the user executing the workout
    private Long workoutProgramId;  // Reference to the workout program
    private String status;  // Assigned, Ongoing, Done, Refused
    private LocalDateTime startDate;  // Start date and time of the workout
    private LocalDateTime endDate;  // End date and time of the workout
    private List<SessionLogDTO> sessionLogDTOs;  // List of exercises performed

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getWorkoutProgramId() {
        return workoutProgramId;
    }

    public void setWorkoutProgramId(Long workoutProgramId) {
        this.workoutProgramId = workoutProgramId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<SessionLogDTO> getSessionLogDTOs() {
        return sessionLogDTOs;
    }

    public void setSessionLogDTOs(List<SessionLogDTO> sessionLogDTOs) {
        this.sessionLogDTOs = sessionLogDTOs;
    }
}

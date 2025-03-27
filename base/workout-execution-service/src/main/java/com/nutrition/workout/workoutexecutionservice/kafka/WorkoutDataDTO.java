package com.nutrition.workout.workoutexecutionservice.kafka;

public class WorkoutDataDTO {
    private Long athleteId;
    private Long workoutProgramId;
    private String workoutStatus; // e.g., "Completed", "In Progress"

    // Constructors, getters, setters
    public WorkoutDataDTO(Long athleteId, Long workoutProgramId, String workoutStatus) {
        this.athleteId = athleteId;
        this.workoutProgramId = workoutProgramId;
        this.workoutStatus = workoutStatus;
    }

    public Long getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }

    public Long getWorkoutProgramId() {
        return workoutProgramId;
    }

    public void setWorkoutProgramId(Long workoutProgramId) {
        this.workoutProgramId = workoutProgramId;
    }

    public String getWorkoutStatus() {
        return workoutStatus;
    }

    public void setWorkoutStatus(String workoutStatus) {
        this.workoutStatus = workoutStatus;
    }
}


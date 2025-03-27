package com.nutrition.workout.workoutexecutionservice;

import com.nutrition.workout.workoutexecutionservice.domain.SessionLog;
import com.nutrition.workout.workoutexecutionservice.domain.WorkoutExecution;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkoutExecutionService {

    // In-memory data store for workout executions
    private final Map<Long, WorkoutExecution> workoutExecutionMap = new HashMap<>();
    private Long idCounter = 1L;

    // Create a new workout execution
    public WorkoutExecution createWorkoutExecution(WorkoutExecution workoutExecution) {
        workoutExecution.setId(idCounter++);
        workoutExecutionMap.put(workoutExecution.getId(), workoutExecution);
        return workoutExecution;
    }

    // Get a specific workout execution by ID
    public WorkoutExecution getWorkoutExecution(Long id) {
        return workoutExecutionMap.get(id);
    }

    // Update an existing workout execution
    public WorkoutExecution updateWorkoutExecution(Long id, WorkoutExecution workoutExecution) {
        WorkoutExecution existingExecution = workoutExecutionMap.get(id);

        if (existingExecution != null) {
            // Update basic fields
            existingExecution.setUserId(workoutExecution.getUserId());
            existingExecution.setWorkoutProgramId(workoutExecution.getWorkoutProgramId());
            existingExecution.setStatus(workoutExecution.getStatus());
            existingExecution.setStartDate(workoutExecution.getStartDate());
            existingExecution.setEndDate(workoutExecution.getEndDate());

            // Update session logs
            List<SessionLog> existingSessionLogs = existingExecution.getSessionLogs();
            List<SessionLog> newSessionLogs = workoutExecution.getSessionLogs();

            if (newSessionLogs != null) {
                // Replace or update session logs
                for (int i = 0; i < newSessionLogs.size(); i++) {
                    SessionLog newSessionLog = newSessionLogs.get(i);
                    if (i < existingSessionLogs.size()) {
                        // Update existing session log
                        SessionLog existingSessionLog = existingSessionLogs.get(i);
                        existingSessionLog.setName(newSessionLog.getName());
                        existingSessionLog.setExercises(newSessionLog.getExercises());
                        existingSessionLog.setCreatedAt(newSessionLog.getCreatedAt());
                        existingSessionLog.setUpdatedAt(newSessionLog.getUpdatedAt());
                    } else {
                        // Add new session log
                        existingSessionLogs.add(newSessionLog);
                    }
                }
            }

            // Return the updated workout execution
            return existingExecution;
        }

        return null;  // If no existing execution is found
    }


    // Delete a workout execution by ID
    public boolean deleteWorkoutExecution(Long id) {
        return workoutExecutionMap.remove(id) != null;
    }
}

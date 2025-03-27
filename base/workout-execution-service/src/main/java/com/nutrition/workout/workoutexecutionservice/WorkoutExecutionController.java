package com.nutrition.workout.workoutexecutionservice;

import com.nutrition.workout.workoutexecutionservice.DTOs.WorkoutExecutionDTO;
import com.nutrition.workout.workoutexecutionservice.domain.WorkoutExecution;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("workout-execution/api/v1/workout-executions")
public class WorkoutExecutionController {

    private final WorkoutExecutionService workoutExecutionService;

    // Constructor injection for WorkoutExecutionService
    public WorkoutExecutionController(WorkoutExecutionService workoutExecutionService) {
        this.workoutExecutionService = workoutExecutionService;
    }

    // Create a new workout execution
    @PostMapping
    public ResponseEntity<WorkoutExecution> createWorkoutExecution(@RequestBody WorkoutExecution workoutExecution) {
        WorkoutExecution createdWorkoutExecution = workoutExecutionService.createWorkoutExecution(workoutExecution);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWorkoutExecution);
    }

    // Get a specific workout execution by ID
    @GetMapping("/{id}")
    public ResponseEntity<WorkoutExecution> getWorkoutExecution(@PathVariable Long id) {
        WorkoutExecution workoutExecution = workoutExecutionService.getWorkoutExecution(id);
        return workoutExecution != null ? ResponseEntity.ok(workoutExecution) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Update an existing workout execution
    @PutMapping("/{id}")
    public ResponseEntity<WorkoutExecution> updateWorkoutExecution(
            @PathVariable Long id, @RequestBody WorkoutExecution workoutExecution) {
        WorkoutExecution updatedWorkoutExecution = workoutExecutionService.updateWorkoutExecution(id, workoutExecution);
        return updatedWorkoutExecution != null ? ResponseEntity.ok(updatedWorkoutExecution) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete a workout execution
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkoutExecution(@PathVariable Long id) {
        boolean isDeleted = workoutExecutionService.deleteWorkoutExecution(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
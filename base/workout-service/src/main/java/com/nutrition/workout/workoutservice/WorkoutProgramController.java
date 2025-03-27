package com.nutrition.workout.workoutservice;

import com.nutrition.workout.workoutservice.DTOs.WorkoutProgramDTO;
import com.nutrition.workout.workoutservice.domain.WorkoutProgram;
import com.nutrition.workout.workoutservice.service.WorkoutProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("workout/api/v1/workout-programs")
public class WorkoutProgramController {

    private final WorkoutProgramService workoutProgramService;

    // Constructor injection for WorkoutProgramService
    public WorkoutProgramController(WorkoutProgramService workoutProgramService) {
        this.workoutProgramService = workoutProgramService;
    }

    // Create a new workout program
    @PostMapping
    public ResponseEntity<WorkoutProgram> createWorkoutProgram(@RequestBody WorkoutProgram workoutProgram) {
        WorkoutProgram createdWorkoutProgram = workoutProgramService.createWorkoutProgram(workoutProgram);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWorkoutProgram);
    }

    // Get a specific workout program by ID
    @GetMapping("/{id}")
    public ResponseEntity<WorkoutProgram> getWorkoutProgram(@PathVariable Long id) {
        WorkoutProgram workoutProgram = workoutProgramService.getWorkoutProgram(id);
        return workoutProgram != null ? ResponseEntity.ok(workoutProgram) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Update an existing workout program
    @PutMapping("/{id}")
    public ResponseEntity<WorkoutProgram> updateWorkoutProgram(
            @PathVariable Long id, @RequestBody WorkoutProgram workoutProgram) {
        WorkoutProgram updatedWorkoutProgram = workoutProgramService.updateWorkoutProgram(id, workoutProgram);
        return updatedWorkoutProgram != null ? ResponseEntity.ok(updatedWorkoutProgram) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete a workout program
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkoutProgram(@PathVariable Long id) {
        boolean isDeleted = workoutProgramService.deleteWorkoutProgram(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/testKafka")
    public void testKafka() {
        workoutProgramService.testKafka();
    }
}
package com.nutrition.workout.workoutservice.service;

import com.nutrition.workout.workoutservice.domain.Exercise;
import com.nutrition.workout.workoutservice.domain.Session;
import com.nutrition.workout.workoutservice.domain.WorkoutProgram;
import com.nutrition.workout.workoutservice.event.Event;
import com.nutrition.workout.workoutservice.kafka.WorkoutProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkoutProgramService {

    @Autowired
    private WorkoutProducerService workoutProducerService;

    // In-memory data store for workout programs
    private final Map<Long, WorkoutProgram> workoutProgramMap = new HashMap<>();
    private Long idCounter = 1L;

    // Create a new workout program
    public WorkoutProgram createWorkoutProgram(WorkoutProgram workoutProgram) {
        workoutProgram.setId(idCounter++);
        workoutProgramMap.put(workoutProgram.getId(), workoutProgram);
        return workoutProgram;
    }

    // Get a specific workout program by ID
    public WorkoutProgram getWorkoutProgram(Long id) {
        return workoutProgramMap.get(id);
    }

    // Update an existing workout program
    public WorkoutProgram updateWorkoutProgram(Long id, WorkoutProgram workoutProgram) {
        WorkoutProgram existingProgram = workoutProgramMap.get(id);

        if (existingProgram != null) {
            // Update basic fields
            existingProgram.setName(workoutProgram.getName());
            existingProgram.setDescription(workoutProgram.getDescription());

            // Update assigned users
            if (workoutProgram.getAssignedUsers() != null) {
                existingProgram.setAssignedUsers(workoutProgram.getAssignedUsers());
            }

            // Update sessions
            List<Session> existingSessions = existingProgram.getSessions();
            List<Session> newSessions = workoutProgram.getSessions();

            if (newSessions != null) {
                // Replace or update sessions
                for (int i = 0; i < newSessions.size(); i++) {
                    Session newSession = newSessions.get(i);
                    if (i < existingSessions.size()) {
                        // Update existing session
                        Session existingSession = existingSessions.get(i);
                        existingSession.setName(newSession.getName());
                        existingSession.setDescription(newSession.getDescription());
                        existingSession.setCreatedAt(newSession.getCreatedAt());
                        existingSession.setUpdatedAt(newSession.getUpdatedAt());

                        // Update exercises in the session
                        List<Exercise> existingExercises = existingSession.getExercises();
                        List<Exercise> newExercises = newSession.getExercises();
                        if (newExercises != null) {
                            for (int j = 0; j < newExercises.size(); j++) {
                                Exercise newExercise = newExercises.get(j);
                                if (j < existingExercises.size()) {
                                    // Update existing exercise
                                    Exercise existingExercise = existingExercises.get(j);
                                    existingExercise.setRepetitions(newExercise.getRepetitions());
                                    existingExercise.setSets(newExercise.getSets());
                                } else {
                                    // Add new exercise
                                    existingExercises.add(newExercise);
                                }
                            }
                        }
                    } else {
                        // Add new session
                        existingSessions.add(newSession);
                    }
                }
            }

            // Update the program's timestamps
            existingProgram.setUpdatedAt(workoutProgram.getUpdatedAt());

            // Return the updated workout program
            return existingProgram;
        }

        return null;  // If no existing program is found
    }


    // Delete a workout program by ID
    public boolean deleteWorkoutProgram(Long id) {
        return workoutProgramMap.remove(id) != null;
    }

    public void testKafka(){
        Event event = new Event();
        event.setEventName("now sending quarto event");
        workoutProducerService.sendMessage(event);
    }
}

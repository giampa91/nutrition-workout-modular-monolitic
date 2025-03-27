package com.nutrition.workout.workoutexecutionservice.kafka;

import com.nutrition.workout.workoutexecutionservice.event.MessageDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WorkoutConsumerService {

    public static final String GROUP_ID = "workout-consumer-group";
    public static final String WORKOUT_TOPIC = "workout-topic";

    @KafkaListener(topics = WORKOUT_TOPIC, groupId = GROUP_ID)
    public void listen(MessageDto message) {
        System.out.println(message.getEventName());
    }

}
package com.nutrition.workout.workoutservice.kafka;

import com.nutrition.workout.workoutservice.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WorkoutProducerService {

    private final KafkaTemplate<String, Event> kafkaTemplate;
    private final String topic = "workout-topic"; // Your Kafka topic

    @Autowired
    public WorkoutProducerService(KafkaTemplate<String, Event> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Event message) {
        // Send the message to the Kafka topic
        kafkaTemplate.send(topic, message);
    }
}

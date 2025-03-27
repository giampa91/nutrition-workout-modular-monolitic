package com.nutrition.workout.workoutservice.kafka;

import com.nutrition.workout.workoutservice.event.Event;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageServiceTest {

    @Autowired
    private WorkoutProducerService workoutProducerService;

    @Test
    public void test(){
        Event event = new Event();
        event.setEventName("now sending terzo event");
        workoutProducerService.sendMessage(event);
    }

}
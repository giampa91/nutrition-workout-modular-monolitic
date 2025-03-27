package com.nutrition.workout.workoutexecutionservice.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nutrition.workout.workoutexecutionservice.event.MessageDto;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

// not used eventually needed for kafka
public class CustomDeserializer implements Deserializer<MessageDto> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public MessageDto deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(data, StandardCharsets.UTF_8), MessageDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Error when deserializing byte[] to MessageDto");
        }
    }

    @Override
    public void close() {
    }
}


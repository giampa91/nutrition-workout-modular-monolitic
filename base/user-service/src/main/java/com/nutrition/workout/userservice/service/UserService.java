package com.nutrition.workout.userservice.service;

import com.nutrition.workout.userservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    // In-memory data store for users
    private final Map<Long, User> userMap = new HashMap<>();
    private Long idCounter = 1L;

    // Create a new user
    public User createUser(User user) {
        user.setId(idCounter++);
        userMap.put(user.getId(), user);
        return user;
    }

    // Get user by ID
    public User getUser(Long id) {
        return userMap.get(id);
    }

    // Get all users
    public Map<Long, User> getAllUsers() {
        return userMap;
    }

    // Update user details
    public User updateUser(Long id, User user) {
        User existingUser = userMap.get(id);
        if (existingUser != null) {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            return existingUser;
        }
        return null;
    }

    // Delete a user
    public boolean deleteUser(Long id) {
        return userMap.remove(id) != null;
    }
}

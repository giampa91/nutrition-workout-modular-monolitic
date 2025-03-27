package com.nutrition.workout.userservice.domain;

import java.util.List;

public class User {
    private CommonUser commonUser;
    public String role;
    private List<User> users;

    public Long getId() {
        return commonUser.getId();
    }

    public void setId(Long id) {
        commonUser.setId(id);
    }

    public String getFirstName() {
        return commonUser.getFirstName();
    }

    public void setFirstName(String firstName) {
        commonUser.setFirstName(firstName);
    }

    public String getLastName() {
        return commonUser.getLastName();
    }

    public void setLastName(String lastName) {
        commonUser.setLastName(lastName);
    }

    public String getEmail() {
        return commonUser.getEmail();
    }

    public void setEmail(String email) {
        commonUser.setEmail(email);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
package com.example.customannotation.model;

import com.example.customannotation.annotation.Alphabetic;

public class User {
    @Alphabetic(message = "Name must contain only alphabetic characters")
    private String name;

    // Constructors, getters, and setters
    public User() {}

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.example.customannotation.controller;

import com.example.customannotation.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid User user) {
        // If validation passes, process the user object
        return new ResponseEntity<>("User is valid", HttpStatus.OK);
    }
}

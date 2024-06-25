package com.example.customannotation.controller;

import com.example.customannotation.annotation.ApiOperationCustom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OpenApiController {

    @ApiOperationCustom(value = "Get all items", notes = "Returns a list of all items")
    @GetMapping("/items")
    public List<String> getItems() {
        return List.of("item1", "item2", "item3");
    }
}

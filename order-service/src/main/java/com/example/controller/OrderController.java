package com.example.controller;

import com.example.dto.OrderDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @GetMapping("/user/{userId}")
    public List<OrderDto> getByUser(@PathVariable Long userId){
        return List.of(new OrderDto(100L, userId, "Laptop", 1));
    }
}

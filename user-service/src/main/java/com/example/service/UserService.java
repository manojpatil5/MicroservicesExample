package com.example.service;

import com.example.client.OrderClient;
import com.example.dto.OrderDto;
import com.example.dto.UserDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final OrderClient orderClient;
    public UserService(OrderClient orderClient){this.orderClient = orderClient;}


    public UserDto getUser(Long id){ return new UserDto(id, "Manoj", "manoj@example.com"); }

    @CircuitBreaker(name = "orderServiceCB", fallbackMethod = "orderFallback")
    public List<OrderDto> getUserOrders(Long id){
        return orderClient.getOrdersByUser(id);
    }

    public List<OrderDto> orderFallback(Long userId, Throwable t){
       // return cached or empty list
        return List.of();
    }
}
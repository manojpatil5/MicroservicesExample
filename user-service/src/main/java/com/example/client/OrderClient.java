package com.example.client;
import com.example.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-service")
public interface OrderClient {
    @GetMapping("/api/orders/user/{userId}")
    List<OrderDto> getOrdersByUser(@PathVariable("userId") Long userId);
}
package com.menaka.ecart.controller;

import com.menaka.ecart.dto.CreateOrderRequest;
import com.menaka.ecart.dto.OrderCreated;
import com.menaka.ecart.entity.Order;
import com.menaka.ecart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //for cfeating order
    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest orderRequest) {
        OrderCreated orderCreated = orderService.createOrder(orderRequest);
        return ResponseEntity.ok().body(orderCreated);
    }

    //for getting order
    @GetMapping("/{referenceId}")
    public ResponseEntity<?> getOrder(@PathVariable String referenceId) {
        Order order = orderService.getOrder(referenceId);
        return ResponseEntity.ok().body(order);
    }

}

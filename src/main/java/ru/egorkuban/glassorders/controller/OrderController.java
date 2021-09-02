package ru.egorkuban.glassorders.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.egorkuban.glassorders.model.Order;
import ru.egorkuban.glassorders.service.OrderService;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return new ResponseEntity("Created!", HttpStatus.OK);
    }

    @GetMapping("/{customerid}")
    public ResponseEntity<List<Order>> byCustomer(@PathVariable(value = "customerid") Long customerId) {
//        List<Order> allByCustomerId = orderService.getAllByCustomerId(customerId);
        return new ResponseEntity<>(orderService.getAllByCustomerId(customerId), HttpStatus.OK);
    }
}

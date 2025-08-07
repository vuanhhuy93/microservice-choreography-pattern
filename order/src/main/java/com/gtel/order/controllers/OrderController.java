package com.gtel.order.controllers;

import com.gtel.order.models.request.CreateOrderRequest;
import com.gtel.order.models.response.MainResponse;
import com.gtel.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class  OrderController {

    // tao order
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public MainResponse<String> createOrder(@RequestBody CreateOrderRequest request){
        return orderService.createOrder(request);
    }
}

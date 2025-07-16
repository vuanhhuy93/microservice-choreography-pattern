package com.gtel.order.models.request;

import com.gtel.order.models.dto.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
    private List<OrderItem> items;

    private long shippingMethod;

    private String address;

    private String phoneNumber;
}

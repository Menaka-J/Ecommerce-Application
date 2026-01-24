package com.menaka.ecart.dto;

import java.util.List;

public class CreateOrderRequest {
    private List<OrderItemDto> orderItems;

    //getter and setter

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }
}

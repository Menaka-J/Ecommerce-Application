package com.menaka.ecart.entity;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Order {

    private List<OrderItem> orderItems;
    private Double totalItemsAmount;
    private Double taxAmount;
    private Double totalAmount;
    private String status;
    private String orderNo;

}

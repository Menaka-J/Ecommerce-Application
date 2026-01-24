package com.menaka.ecart.entity;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Order {

    private List<OrderItem> orderItems;
}

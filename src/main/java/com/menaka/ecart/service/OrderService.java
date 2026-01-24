package com.menaka.ecart.service;

import com.menaka.ecart.dto.CreateOrderRequest;
import com.menaka.ecart.dto.OrderItemDto;
import com.menaka.ecart.entity.Order;
import com.menaka.ecart.entity.OrderItem;
import com.menaka.ecart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ProductRepository prodRepo;

    public void createOrder(CreateOrderRequest orderRequest) {
        Order order = new Order();

        for (OrderItemDto item : orderRequest.getOrderItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setName(item.getName());
            orderItem.setPrice(item.getPrice());
            orderItem.setImage(item.getImage());
            orderItem.setQuantity(item.getQuantity());
        }
    }


}

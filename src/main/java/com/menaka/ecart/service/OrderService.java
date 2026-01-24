package com.menaka.ecart.service;

import com.menaka.ecart.dto.CreateOrderRequest;
import com.menaka.ecart.dto.OrderItemDto;
import com.menaka.ecart.entity.Order;
import com.menaka.ecart.entity.OrderItem;
import com.menaka.ecart.entity.Product;
import com.menaka.ecart.repository.OrderRepository;
import com.menaka.ecart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ProductRepository prodRepo;

    @Autowired
    private OrderRepository orderRepo;

    public void createOrder(CreateOrderRequest orderRequest) {
        Order order = new Order();
        order.setStatus("PENDING");
        double totalItemsAmount = 0;

        for (OrderItemDto item : orderRequest.getOrderItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setName(item.getName());
            orderItem.setPrice(item.getPrice());
            orderItem.setImage(item.getImage());
            orderItem.setQuantity(item.getQuantity());

            Product product = prodRepo.findById(item.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
            orderItem.setProduct(product);
            totalItemsAmount += item.getPrice() * item.getQuantity();

            order.getOrderItems().add(orderItem);
        }
        order.setTotalItemsAmount(totalItemsAmount);
        double totalAmount = 0;
        double taxAmount = 10;
        totalAmount = totalItemsAmount + taxAmount;
        order.setTotalAmount(totalAmount);
        order.setTaxAmount(taxAmount);
    }


}

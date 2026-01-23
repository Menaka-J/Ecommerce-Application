package com.menaka.ecart.service;

import com.menaka.ecart.entity.Product;
import com.menaka.ecart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Map<String, Object> getALlProducte(int page, int size) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("products", products.getContent());
        response.put("totalProducts", products.getTotalElements());
        return response;
    }
}

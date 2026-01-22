package com.menaka.ecart.service;

import com.menaka.ecart.entity.Product;
import com.menaka.ecart.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> getALlProducte() {
        List<Product> products = productRepository.findAll();
        return products;
    }
}

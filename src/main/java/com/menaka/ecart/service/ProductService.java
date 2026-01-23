package com.menaka.ecart.service;

import com.menaka.ecart.entity.Product;
import com.menaka.ecart.repository.ProductRepository;
import com.menaka.ecart.spec.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //getting all products
    //return only selected no.of items
    public Map<String, Object> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("products", products.getContent());
        response.put("totalProducts", products.getTotalElements());
        return response;
    }

    //for getting product by id
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found exception" + id));
    }

    //FOR SEARCHING PRODUCTS
    public List<Product> searchProducts(String category, Double minPrice, Double maxPrice, String Keyword) {
        Specification<Product> spec = Specification.where(ProductSpecification.hasCategory(category)) //by category
                .and(ProductSpecification.priceBetween(minPrice, maxPrice))
                .and();
        return productRepository.findAll(spec);
    }


}

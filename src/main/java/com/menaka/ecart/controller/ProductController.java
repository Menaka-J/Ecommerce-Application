package com.menaka.ecart.controller;

import com.menaka.ecart.entity.Product;
import com.menaka.ecart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //getting all products form service packeg
    @GetMapping
    public Map<String, Object> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return productService.getAllProducts(page, size);
    }

    //GETTING PRODUCT BY ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    //FOR SERACHING PRODUCTS
    public List<Product> searchProducts(@RequestParam String category, @RequestParam Double minPrice, @RequestParam Double maxPrice, @RequestParam String keyword) {


    }


}

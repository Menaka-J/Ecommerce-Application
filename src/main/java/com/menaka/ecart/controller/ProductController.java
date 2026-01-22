package com.menaka.ecart.controller;

import com.menaka.ecart.entity.Product;
import com.menaka.ecart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //getting all products form service packeg
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getALlProducte();
        return ResponseEntity.ok(products);
    }

}

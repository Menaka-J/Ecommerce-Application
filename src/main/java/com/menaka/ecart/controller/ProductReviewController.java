package com.menaka.ecart.controller;

import com.menaka.ecart.dto.ProductReviewDto;
import com.menaka.ecart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/reviews")
public class ProductReviewController {

    @Autowired
    private ProductService productService;

    //for adding review
    public ResponseEntity<?> addReview(@RequestBody ProductReviewDto reviewDto) {
        productService.addReview(reviewDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Review added");
    }
}

//DTO = DATA TRANSFER OBJECT
//we shouldn't use direct entity instance, instead we use Dto instance
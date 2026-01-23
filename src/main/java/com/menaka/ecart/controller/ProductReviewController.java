package com.menaka.ecart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/reviews")
public class ProductReviewController {

    //for adding review
    public ResponseEntity<?> addReview(@RequestBody ProductReviewDto reviewDto)
}

//DTO = DATA TRANSFER OBJECT
//we shouldn't use direct entity instance, instead we use Dto instance
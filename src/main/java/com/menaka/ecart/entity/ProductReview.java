package com.menaka.ecart.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1)
    @Max(value = 5)
    private Double rating;

    private String comment;

    //constructors


    public ProductReview(Long id, Double rating, String comment) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
    }

    public ProductReview() {

    }

    //getter and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @Min(value = 1) @Max(value = 5) Double getRating() {
        return rating;
    }

    public void setRating(@Min(value = 1) @Max(value = 5) Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //new field
    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    //getter and settre for product

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

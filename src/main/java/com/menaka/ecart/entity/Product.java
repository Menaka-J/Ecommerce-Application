package com.menaka.ecart.entity;

public class Product {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private Double ratings = 0.0;
    private String seller;
    private Integer stock;
    private Integer numOfReviews = 0;

    //constructor for initialization
    public Product(String seller, Long id, String name, Double price, String description, Double ratings, Integer stock, Integer numOfReviews) {
        this.seller = seller;
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.ratings = ratings;
        this.stock = stock;
        this.numOfReviews = numOfReviews;
    }

    //getter and setter for all columns

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getNumOfReviews() {
        return numOfReviews;
    }

    public void setNumOfReviews(Integer numOfReviews) {
        this.numOfReviews = numOfReviews;
    }
}

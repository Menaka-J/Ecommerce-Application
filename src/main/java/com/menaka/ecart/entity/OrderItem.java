package com.menaka.ecart.entity;

public class OrderItem {

    private String name;
    private Integer quantity;
    private String image;
    private Double price;
    private Product product;

    //constructor

    public OrderItem(String name, Integer quantity, String image, Double price, Product product) {
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.price = price;
        this.product = product;
    }

    public OrderItem() {
    }

    //gettre and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

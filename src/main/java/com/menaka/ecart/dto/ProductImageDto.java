package com.menaka.ecart.dto;

public class ProductImageDto {

    private String url;

    //constructor

    public ProductImageDto(String url) {
        this.url = url;
    }

    //getter and setter

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

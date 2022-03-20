package com.quinbay.Ecommerce.backend.dto;

public class Product {
    private Long id;  //primary key
    private Long sellerId;  //secondary key
    private String name;
    private String details;
    private String image;
    private double price;
    private Long stock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Product(Long id, Long sellerId, String name, String details, String image, double price, Long stock) {
        this.id = id;
        this.sellerId = sellerId;
        this.name = name;
        this.details = details;
        this.image = image;
        this.price = price;
        this.stock = stock;
    }
}

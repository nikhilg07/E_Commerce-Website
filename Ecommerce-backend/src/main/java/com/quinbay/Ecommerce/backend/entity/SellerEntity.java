package com.quinbay.Ecommerce.backend.entity;

public class SellerEntity {
    private Long id;
    private String name;
    private double ratings;

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

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public SellerEntity(Long id, String name, double ratings) {
        this.id = id;
        this.name = name;
        this.ratings = ratings;
    }
}

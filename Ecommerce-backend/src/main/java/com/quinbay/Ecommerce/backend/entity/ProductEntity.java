package com.quinbay.Ecommerce.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name="products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;  //primary key
//    private Long sellerId;  //secondary key


    @NotBlank(message = "Product Name cannot be null")
    private String name, details, image;
    private double price;
    private Long stock;

    @ManyToOne
    @JoinColumn(name = "sellerId", referencedColumnName = "id")
    SellerEntity sellerProducts;

//    SellerEntity sellerEntity;

    public ProductEntity(){};

    public ProductEntity(Long id, @NotBlank(message = "Product Name cannot be null") String name, @NotBlank(message = "Product Name cannot be null") String details, @NotBlank(message = "Product Name cannot be null") String image, double price, Long stock, Long sellerProducts) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.image = image;
        this.price = price;
        this.stock = stock;
//        this.sellerProducts.contains() = sellerProducts;
        this.sellerProducts.setId(sellerProducts);
    }

    public SellerEntity getSellerProducts() {
        return sellerProducts;
    }

    public void setSellerProducts(SellerEntity sellerProducts) {
        this.sellerProducts = sellerProducts;
    }

    public Long getSellerId() {
        return sellerProducts.getId();
    }

    public void setSellerId(Long sellerProducts) {
        this.sellerProducts.setId(sellerProducts);
    }

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

//    public Set<SellerEntity> getSellerProducts() {
//        return sellerProducts;
//    }

//    public void setSellerProducts(Set<SellerEntity> sellerProducts) {
//        this.sellerProducts = sellerProducts;
//    }
}



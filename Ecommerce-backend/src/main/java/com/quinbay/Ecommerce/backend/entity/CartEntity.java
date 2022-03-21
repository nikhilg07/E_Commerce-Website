package com.quinbay.Ecommerce.backend.entity;

import javax.persistence.*;

@Entity
@Table(name="cart")
public class CartEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   //primary key
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    ProductEntity productEntity;

    public CartEntity(Long id, Integer quantity, Long userId, Long productId) {
        this.id = id;
        this.quantity = quantity;
        this.userEntity.setId(userId);
        this.productEntity.setId(productId);
    }
    public CartEntity(){}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
       return productEntity.getId();
   }

   public Long getUserId(){
        return userEntity.getId();
   }
}


//public void setSellerProducts(SellerEntity sellerProducts) {
//        this.sellerProducts = sellerProducts;
//    }
//
//    public Long getSellerId() {
//        return sellerProducts.getId();
//    }

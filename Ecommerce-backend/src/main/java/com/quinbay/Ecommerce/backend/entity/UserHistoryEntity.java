package com.quinbay.Ecommerce.backend.entity;

public class UserHistoryEntity {
    private Long id; //primary key
    private Long userId; //foreign key
    private Long productId;  //foreign key

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserHistoryEntity(Long id,Long userId, Long productId) {
        this.id=id;
        this.userId = userId;
        this.productId = productId;
    }
}

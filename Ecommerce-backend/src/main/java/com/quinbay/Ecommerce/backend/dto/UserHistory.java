package com.quinbay.Ecommerce.backend.dto;

public class UserHistory {
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

    public UserHistory(Long userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
    }
}

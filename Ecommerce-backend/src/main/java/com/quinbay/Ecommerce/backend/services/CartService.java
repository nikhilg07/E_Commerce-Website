package com.quinbay.Ecommerce.backend.services;

import com.quinbay.Ecommerce.backend.dto.Cart;

import java.util.List;

public interface CartService {
    void addProductToCart(Cart cart);
    List<Cart> getCartDetailsByUserId(Long userid);

}

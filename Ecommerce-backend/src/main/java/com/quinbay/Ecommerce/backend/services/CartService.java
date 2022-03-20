package com.quinbay.Ecommerce.backend.services;

import com.quinbay.Ecommerce.backend.dto.Cart;
import com.quinbay.Ecommerce.backend.dto.Product;

import java.util.List;

public interface CartService {
    List<Cart>getCartItems();
    void addProduct(Cart cart);
    void updateCart(Cart cart);
    void delete(Cart cart);
}

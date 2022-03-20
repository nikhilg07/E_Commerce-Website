package com.quinbay.Ecommerce.backend.services;

import com.quinbay.Ecommerce.backend.dto.Cart;
import com.quinbay.Ecommerce.backend.entity.CartEntity;
import com.quinbay.Ecommerce.backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService{

    @Autowired
    CartRepository cartRepository;


    @Override
    public List<Cart> getCartItems(){

        Iterable<CartEntity> cartEntities = cartRepository.findAll();
        List<Cart> list = new ArrayList<>();
        for (CartEntity cE : cartEntities) {
            list.add(new Cart(cE.getId(),cE.getProductId(),cE.getUserId()));
        }
        return list;

    }

    @Override
    public void addProduct(Cart cart){
        cartRepository.save(new CartEntity(cart.getId(),cart.getProductId(),cart.getUserId()));

    }

    @Override
    public void updateCart(Cart cart){
        CartEntity cartEntity = new CartEntity(cart.getId(),cart.getProductId(),cart.getUserId());

        cartRepository.save(cartEntity);

    }

    @Override
    public  void delete(Cart cart){
        CartEntity cartEntity = new CartEntity(cart.getId(),cart.getProductId(),cart.getUserId());
        cartRepository.delete(cartEntity);

    }


}


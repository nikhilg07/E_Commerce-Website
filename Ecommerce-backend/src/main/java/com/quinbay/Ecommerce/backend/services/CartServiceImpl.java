package com.quinbay.Ecommerce.backend.services;

import com.quinbay.Ecommerce.backend.dto.Cart;
import com.quinbay.Ecommerce.backend.entity.CartEntity;
import com.quinbay.Ecommerce.backend.entity.ProductEntity;
import com.quinbay.Ecommerce.backend.entity.UserEntity;
import com.quinbay.Ecommerce.backend.repository.CartRepository;
import com.quinbay.Ecommerce.backend.repository.ProductRepository;
import com.quinbay.Ecommerce.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;


//    @Override
//    public List<Cart> getCartItems(){
//
//        Iterable<CartEntity> cartEntities = cartRepository.findAll();
//        List<Cart> list = new ArrayList<>();
//        for (CartEntity cartEntity : cartEntities) {
//            list.add(new Cart());
//        }
//        return list;
//
//    }

    @Override
    public void addProductToCart(Cart cart){
        //CartEntity cartEntity = new CartEntity();
        Optional<UserEntity> byId = userRepository.findById(cart.getUserId());
        Optional<ProductEntity> byPid = productRepository.findById(cart.getProductId());
        if(byId.isPresent()){
            if(byPid.isPresent()) {
                cartRepository.save(new CartEntity(cart.getId(),cart.getQuantity(), cart.getUserId(), cart.getProductId()));
            }

        }

    }

    @Override
    public  List<Cart> getCartDetailsByUserId(Long userid){
        Iterable<CartEntity> cartEntityList = cartRepository.findAll();
        List <Cart> cartList = new ArrayList<>();
        for(CartEntity cartEntity: cartEntityList){
            if(cartEntity.getUserId()==userid){
                cartList.add(new Cart(cartEntity.getId(),cartEntity.getProductId(),cartEntity.getUserId(),cartEntity.getQuantity()));
            }
        }
        return cartList;
    }
//    @Override
//    public void updateCart(Cart cart){
//        CartEntity cartEntity = new CartEntity(cart.getId(),cart.getProductId(),cart.getUserId());
//
//        cartRepository.save(cartEntity);
//
//    }

//    @Override
//    public  void delete(Cart cart){
//        CartEntity cartEntity = new CartEntity(cart.getId(),cart.getProductId(),cart.getUserId());
//        cartRepository.delete(cartEntity);
//
//    }


}

//ProductEntity productEntity = new ProductEntity();
//
//        Optional<SellerEntity> byId=sellerRepository.findById(product.getSellerId());
//        if(byId.isPresent()){
//            productEntity.setSellerProducts(byId.get());
//            productEntity.setStock(product.getStock());
//            productEntity.setPrice(product.getPrice());
//            productEntity.setImage(product.getImage());
//            productEntity.setDetails(product.getDetails());
//            productEntity.setName(product.getName());
//            productEntity.setId(product.getId());
//            productRepository.save(productEntity);
//        }

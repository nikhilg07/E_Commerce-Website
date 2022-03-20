package com.quinbay.Ecommerce.backend.services;

import com.quinbay.Ecommerce.backend.dto.Product;
import com.quinbay.Ecommerce.backend.dto.Seller;
import com.quinbay.Ecommerce.backend.entity.ProductEntity;
import com.quinbay.Ecommerce.backend.entity.SellerEntity;
import com.quinbay.Ecommerce.backend.repository.ProductRepository;
import com.quinbay.Ecommerce.backend.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class SellerServiceImpl implements SellerService{

    @Autowired
    SellerRepository sellerRepository;
    ProductRepository productRepository;


    @Autowired
    public void addSeller(Seller seller){

        SellerEntity sellerEntity = new SellerEntity(seller.getId(),seller.getName(),seller.getRatings());

        sellerRepository.save(sellerEntity);
    }

    public List<Product> viewSellerProducts(Long sid){

        Iterable<ProductEntity> productEntities = productRepository.findAll();
        List<Product> plist = new ArrayList<>();

        for(ProductEntity prod:productEntities){
            if(prod.getId()==sid){
                Product p = new Product(prod.getId(),prod.getSellerId(),prod.getName(),prod.getDetails(),prod.getImage(),prod.getPrice(),prod.getStock());
                plist.add(p);

            }
        }

        return plist;




    }

}



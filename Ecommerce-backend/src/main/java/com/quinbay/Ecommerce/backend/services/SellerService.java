package com.quinbay.Ecommerce.backend.services;

import com.quinbay.Ecommerce.backend.dto.Product;
import com.quinbay.Ecommerce.backend.dto.Seller;

import java.util.List;

public interface SellerService {

    void addSeller(Seller seller);

    List<Product> viewSellerProducts(Long sid);


}

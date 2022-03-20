package com.quinbay.Ecommerce.backend.services;

import com.quinbay.Ecommerce.backend.dto.Product;
import com.quinbay.Ecommerce.backend.dto.User;

import java.util.List;

public interface ProductService {
    void addProductsfromSeller(Product product);
    List<Product> getAllProducts();
    void deleteProduct(Product product);
    void updateProduct(Product product);
    Product getProductById(Long id);
}


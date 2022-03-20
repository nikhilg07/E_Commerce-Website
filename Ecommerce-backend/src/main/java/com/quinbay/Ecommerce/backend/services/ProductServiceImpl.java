package com.quinbay.Ecommerce.backend.services;

import com.quinbay.Ecommerce.backend.dto.Product;
import com.quinbay.Ecommerce.backend.entity.ProductEntity;
import com.quinbay.Ecommerce.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void addProductsfromSeller(Product product) {
        productRepository.save(new ProductEntity(product.getId(), product.getSellerId(),
                product.getName(), product.getDetails(),
                product.getImage(), product.getPrice(), product.getStock()));
    }

    @Override
    public List<Product> getAllProducts() {
        Iterable<ProductEntity> productEntities = productRepository.findAll();
        List<Product> list = new ArrayList<>();
        for (ProductEntity prod : productEntities) {
            list.add(new Product(prod.getId(),
                    prod.getSellerId(),
                    prod.getName(),
                    prod.getDetails(),
                    prod.getImage(),
                    prod.getPrice(),
                    prod.getStock()));
        }
        return list;
    }


    @Override
    public void deleteProduct(Product product){
        ProductEntity productEntity = new ProductEntity(product.getId(),product.getSellerId(),product.getName(),product.getDetails(),product.getImage(),product.getPrice(),product.getStock());
        productRepository.delete(productEntity);



    }

    @Override
    public void updateProduct(Product product){
        ProductEntity productEntity = new ProductEntity(product.getId(),product.getSellerId(),product.getName(),product.getDetails(),product.getImage(),product.getPrice(),product.getStock());

        productRepository.save(productEntity);
    }


    @Override
    public Product getProductById(Long id){
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if(productEntity.isPresent()) {
            return new Product(productEntity.get().getId(), productEntity.get().getSellerId(),productEntity.get().getName(),productEntity.get().getDetails(),productEntity.get().getImage(),productEntity.get().getPrice(),productEntity.get().getStock());
        }
        else {
            throw new RuntimeException("Not Found");
        }

    }

}



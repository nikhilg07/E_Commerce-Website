package com.quinbay.Ecommerce.backend.services;

import com.quinbay.Ecommerce.backend.dto.Product;
import com.quinbay.Ecommerce.backend.entity.ProductEntity;
import com.quinbay.Ecommerce.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public void addProducts(Product product){
        ProductEntity productEntity = new ProductEntity();

        Optional<SellerEntity> byId=sellerRepository.findById(product.getSellerId());
        if(byId.isPresent()){
            productEntity.setSellerProducts(byId.get());
            productEntity.setStock(product.getStock());
            productEntity.setPrice(product.getPrice());
            productEntity.setImage(product.getImage());
            productEntity.setDetails(product.getDetails());
            productEntity.setName(product.getName());
            productEntity.setId(product.getId());
            productRepository.save(productEntity);
        }
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
    public Product updateProduct(Product product){
        Iterable<ProductEntity> productEntityIterable = productRepository.findAll();
        for(ProductEntity productEntity :productEntityIterable){
            if(productEntity.getId() == product.getId()){
                productEntity.setStock(product.getStock());
                productRepository.save(productEntity);
            }
        }
        return product;
    }

    @Override
    public void deleteProduct(Long id){
        for(ProductEntity productEntity : productRepository.findAll()){
            if(productEntity.getId()==id){
                productRepository.deleteById(id);
                break;
            }
        }
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

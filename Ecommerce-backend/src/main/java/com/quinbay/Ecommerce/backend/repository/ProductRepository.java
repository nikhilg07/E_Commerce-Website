package com.quinbay.Ecommerce.backend.repository;

import com.quinbay.Ecommerce.backend.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity,Long> {
}

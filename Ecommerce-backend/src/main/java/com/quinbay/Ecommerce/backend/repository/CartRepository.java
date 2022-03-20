package com.quinbay.Ecommerce.backend.repository;

import com.quinbay.Ecommerce.backend.entity.CartEntity;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<CartEntity,Long> {
}

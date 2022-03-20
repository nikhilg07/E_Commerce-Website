package com.quinbay.Ecommerce.backend.repository;

import com.quinbay.Ecommerce.backend.entity.UserHistoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserHistoryRepository extends CrudRepository<UserHistoryEntity,Long> {
}

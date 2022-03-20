package com.quinbay.Ecommerce.backend.services;

import com.quinbay.Ecommerce.backend.dto.User;
import com.quinbay.Ecommerce.backend.entity.UserEntity;
import com.quinbay.Ecommerce.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User user){

        UserEntity u = new UserEntity(user.getId(),user.getEmail(),user.getName());
        userRepository.save(u);
    }

}

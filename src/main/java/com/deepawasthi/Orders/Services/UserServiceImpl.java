package com.deepawasthi.Orders.Services;

import com.deepawasthi.Orders.Entities.UserEntity;
import com.deepawasthi.Orders.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(()->new RuntimeException("No User Found"));
    }

    @Override
    public boolean deleteUserById(int userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("No User Found"));
        userRepository.delete(user);
        return true;
    }
}

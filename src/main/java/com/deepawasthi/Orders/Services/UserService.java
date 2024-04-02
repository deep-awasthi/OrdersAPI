package com.deepawasthi.Orders.Services;

import com.deepawasthi.Orders.Entities.UserEntity;

import java.util.List;

public interface UserService {

    public UserEntity createUser(UserEntity user);
    public List<UserEntity> getAllUsers();
    public UserEntity getUserById(int userId);
    public boolean deleteUserById(int userId);
}

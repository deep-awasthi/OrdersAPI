package com.deepawasthi.Orders.Controllers;

import com.deepawasthi.Orders.Entities.UserEntity;
import com.deepawasthi.Orders.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userService")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @MutationMapping(name = "createUser")
    public UserEntity createUser(@Argument String name, @Argument String email, @Argument String password){
        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        return userService.createUser(user);
    }

    @QueryMapping(name = "getUsers")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @QueryMapping(name = "getUser")
    public UserEntity getUserById(@Argument int userId){
        return userService.getUserById(userId);
    }

    @MutationMapping(name = "deleteUser")
    public boolean deleteUserById(@Argument int userId){
        return userService.deleteUserById(userId);
    }
}

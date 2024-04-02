package com.deepawasthi.Orders.Controllers;

import com.deepawasthi.Orders.Entities.OrderEntity;
import com.deepawasthi.Orders.Entities.UserEntity;
import com.deepawasthi.Orders.Services.OrderServiceImpl;
import com.deepawasthi.Orders.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orderService")
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    UserServiceImpl userService;

    @MutationMapping(name = "createOrder")
    public OrderEntity createOrder(@Argument String orderDetail, @Argument String address, @Argument int price, @Argument int userId){
        UserEntity user = userService.getUserById(userId);
        OrderEntity order = new OrderEntity();
        order.setOrderDetail(orderDetail);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(user);
        return orderService.createOrder(order);
    }

    @QueryMapping(name = "getOrders")
    public List<OrderEntity> getAllOrders(){
        return orderService.getAllOrders();
    }

    @QueryMapping(name = "getOrder")
    public OrderEntity getOrderById(@Argument int orderId){
        return orderService.getOrderById(orderId);
    }

    @MutationMapping(name = "deleteOrder")
    public boolean deleteOrderById(@Argument int orderId){
        return orderService.deleteById(orderId);
    }
}

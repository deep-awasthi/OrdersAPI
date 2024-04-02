package com.deepawasthi.Orders.Services;

import com.deepawasthi.Orders.Entities.OrderEntity;
import com.deepawasthi.Orders.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity getOrderById(int orderId) {
        return orderRepository.findById(orderId).orElseThrow(()->new RuntimeException("No Order Found"));
    }

    @Override
    public boolean deleteById(int orderId) {
        OrderEntity order = orderRepository.findById(orderId).orElseThrow(()->new RuntimeException("No Order Found"));
        orderRepository.delete(order);
        return true;
    }
}

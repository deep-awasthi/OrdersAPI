package com.deepawasthi.Orders.Services;

import com.deepawasthi.Orders.Entities.OrderEntity;

import java.util.List;

public interface OrderService {

    public OrderEntity createOrder(OrderEntity order);
    public List<OrderEntity> getAllOrders();
    public OrderEntity getOrderById(int orderId);
    public boolean deleteById(int orderId);
}

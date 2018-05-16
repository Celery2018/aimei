package com.aimei.service.common.order;

import com.aimei.domain.entity.Order;
import com.aimei.domain.entity.ShoppingCar;

import java.util.List;


public interface OrderService {
    List<Order> getOrderList(String memberId);
    boolean addOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(String id);
}

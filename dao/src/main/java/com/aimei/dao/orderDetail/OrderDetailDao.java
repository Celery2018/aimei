package com.aimei.dao.orderDetail;


import com.aimei.domain.entity.Goods;
import com.aimei.domain.entity.Order;
import com.aimei.domain.entity.OrderDetail;

import java.util.List;

public interface OrderDetailDao {
    List<Goods> getOrderDetail(String orderId);
    boolean addOrderDetail(OrderDetail orderDetail);
    boolean deleteOrderDetail(String orderId);
}

package com.aimei.service.common.order.impl;

import com.aimei.dao.goods.GoodsDao;
import com.aimei.dao.order.OrderDao;
import com.aimei.dao.orderDetail.OrderDetailDao;
import com.aimei.dao.shoppingCar.ShoppingCarDao;
import com.aimei.dao.stock.StockDao;
import com.aimei.domain.entity.*;
import com.aimei.service.common.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    OrderDetailDao orderDetailDao;
    @Autowired
    ShoppingCarDao shoppingCarDao;
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    StockDao stockDao;

    @Override
    public List<Order> getOrderList(String memberId) {
        List<Order> orderList = orderDao.getOrderList(memberId);
        for (Order order : orderList) {
            List<Goods> goods = orderDetailDao.getOrderDetail(order.getId());
            if (goods != null && goods.size() > 0)
                order.setGoods(goods);
        }
        return orderList;
    }

    @Override
    @Transactional
    public boolean addOrder(Order order) {
        try {
            if (order.getShoppingCars() == null || order.getShoppingCars().size() < 1)
                return false;
            //step1:获取购物车对应的商品列表
            List<Goods> goodsList = new ArrayList<>();
            for (ShoppingCar shoppingCar : order.getShoppingCars()) {
                ShoppingCar shoppingCar1 = shoppingCarDao.getShoppingCar(shoppingCar.getId());
                if (shoppingCar1 != null) {
                    List<Goods> goods1 = goodsDao.getGoodsList(shoppingCar1.getGoodsId());
                    if (goods1 != null && goods1.size() > 0) {
                        Goods g1 = goods1.get(0);
                        g1.setNumber(shoppingCar1.getNumber());
                        goodsList.add(g1);
                    }
                }
            }
            //step2:计算总金额
            double allPrice = 0.0;
            for (Goods goods : goodsList) {
                allPrice = allPrice + goods.getPrice() * goods.getNumber();
            }
            //step3:插入订单数据
            order.setOrderGenDate(new Date());
            order.setPrice(allPrice);
            String id = String.valueOf(new Date().getTime());
            order.setId(id);
            boolean addOrder = orderDao.addOrder(order);
            if (!addOrder)
                return false;
            //step4 插入订单详情数据
            for (Goods goods : goodsList) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setGoodsId(goods.getGoodsId());
                orderDetail.setOrderId(id);
                orderDetail.setNumber(goods.getNumber());
                orderDetailDao.addOrderDetail(orderDetail);
            }
            //step5:删除已经提交订单的购物车数据
            for (ShoppingCar shoppingCar : order.getShoppingCars()) {
                shoppingCarDao.deleteShoppingCar(shoppingCar.getId());
            }
            //step6:减少已提交订单的商品库存
            for (Goods goods : goodsList) {
                Stock stock = stockDao.getStock(goods.getGoodsId());
                stock.setNumbers(String.valueOf(Integer.parseInt(stock.getNumbers()) - goods.getNumber()));
                stockDao.updateStock(stock);
            }

        } catch (Exception e) {
            throw new RuntimeException();
        }


        return true;
    }

    @Override
    public boolean updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public boolean deleteOrder(String id) {
        orderDetailDao.deleteOrderDetail(id);
        return orderDao.deleteOrder(id);
    }
}

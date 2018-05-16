package com.aimei.action;


import com.aimei.dao.domain.dto.Result;
import com.aimei.domain.entity.Order;
import com.aimei.domain.entity.ShoppingCar;
import com.aimei.service.common.order.OrderService;
import com.aimei.service.common.shoppingCar.ShoppingCarService;
import com.aimei.util.LogHelper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 订单类
 */
@Controller
@RequestMapping("/order")
public class OrderAction {
    private static final Logger logger = LogHelper.log_consoleFile;


    @Autowired
    private OrderService orderService;

    /**
     * 获取我的订单
     *
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/getOrderList", method = {RequestMethod.GET})
    public @ResponseBody
    Result listUser(String memberId) {
        List<Order> list = orderService.getOrderList(memberId);
        return new Result(true, list);
    }

    /**
     * 新增订单
     *
     * @param order
     * @return
     */
    @RequestMapping(value = "/addOrder", method = {RequestMethod.POST})
    public @ResponseBody
    Result addOrder(@RequestBody Order order) {
        Result result = null;
        try {
            boolean add = orderService.addOrder(order);
            result = new Result(add, add ? "添加订单成功" : "添加订单失败");
        } catch (Exception e) {
            result = new Result(false, "添加订单失败");
        }
        return result;
    }


    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteOrder", method = {RequestMethod.GET})
    public @ResponseBody
    Result deleteGoods(String id) {
        Result result = null;
        try {
            boolean add = orderService.deleteOrder(id);
            result = new Result(add, add ? "删除成功！" : "删除失败");
        } catch (Exception e) {
            result = new Result(false, "删除失败");
        }
        return result;
    }

}

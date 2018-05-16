package com.aimei.action;


import com.aimei.dao.domain.dto.Result;
import com.aimei.dao.shoppingCar.ShoppingCarDao;
import com.aimei.domain.entity.Goods;
import com.aimei.domain.entity.ShoppingCar;
import com.aimei.service.common.goods.GoodsService;
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
 * 商品类，包含商品的各类操作
 */
@Controller
@RequestMapping("/shoppingcar")
public class ShoppingCarAction {
    private static final Logger logger = LogHelper.log_consoleFile;


    @Autowired
    private ShoppingCarService shoppingCarService;

    /**
     * 获取我的购物车
     *
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/getShoppingCartList", method = {RequestMethod.GET})
    public @ResponseBody
    Result listUser(String memberId) {
        List<ShoppingCar> list = shoppingCarService.getShoppingCarList(memberId);
        return new Result(true, list);
    }

    /**
     * 添加到购物车
     *
     * @param shoppingCar
     * @return
     */
    @RequestMapping(value = "/addShoppingCar", method = {RequestMethod.POST})
    public @ResponseBody
    Result addGoods(@RequestBody ShoppingCar shoppingCar) {
        Result result = null;
        try {
            boolean add = shoppingCarService.addShopping(shoppingCar);
            result = new Result(add, add ? "添加购物车成功" : "添加购物车失败");
        } catch (Exception e) {
            result = new Result(false, "添加购物车失败");
        }
        return result;
    }

    /**
     * 更新购物车信息
     *
     * @param shoppingCar
     * @return
     */
    @RequestMapping(value = "/updateShoppingCar", method = {RequestMethod.POST})
    public @ResponseBody
    Result updateGoods(@RequestBody ShoppingCar shoppingCar) {
        Result result = null;
        try {
            boolean add = shoppingCarService.updateShoppingCar(shoppingCar);
            result = new Result(add, add ? "更新成功！" : "更新失败");
        } catch (Exception e) {
            result = new Result(false, "更新失败");
        }

        return result;
    }

    /**
     * 删除一件购物车商品
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteShoppingCar", method = {RequestMethod.GET})
    public @ResponseBody
    Result deleteGoods(String id) {
        Result result = null;
        try {
            boolean add = shoppingCarService.deleteShoppingCar(id);
            result = new Result(add, add ? "删除成功！" : "删除失败");
        } catch (Exception e) {
            result = new Result(false, "删除失败");
        }
        return result;
    }

    /**
     * 删除一件购物车商品
     *
     * @param memberId
     * @return
     */
    @RequestMapping(value = "/clearShoppingCar", method = {RequestMethod.GET})
    public @ResponseBody
    Result clearShoppingCar(String memberId) {
        Result result = null;
        try {
            boolean add = shoppingCarService.clearShoppingCar(memberId);
            result = new Result(add, add ? "清空购物车成功！" : "清空购物车失败");
        } catch (Exception e) {
            result = new Result(false, "清空购物车失败");
        }
        return result;
    }
}

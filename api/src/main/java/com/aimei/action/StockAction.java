package com.aimei.action;


import com.aimei.dao.domain.dto.Result;
import com.aimei.domain.entity.Member;
import com.aimei.domain.entity.Stock;
import com.aimei.service.common.memberService.MemberService;
import com.aimei.service.common.stock.StockService;
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
 * 库存操作类
 */
@Controller
@RequestMapping("/stock")
public class StockAction {
    private static final Logger logger = LogHelper.log_consoleFile;


    @Autowired
    private StockService stockService;


    /**
     * 增加库存,减少库存，以及商品的上架下架
     *
     * @param stock
     * @return
     */
    @RequestMapping(value = "/addStock", method = {RequestMethod.POST})
    public @ResponseBody
    Result listUser(@RequestBody  Stock stock) {
        Result result = null;
        if (stock.getGoodsId() == null || stock.getGoodsId().equals("")) {
            return new Result(false, "商品ID不能为空！");
        }
        Stock list = stockService.getStock(stock.getGoodsId());
        if (list == null)
            return new Result(false, "该商品没有库存！");
//        else if (list.get(0).getWetherPurchase() == 1)
//            return new Result(false, "该商品已下架！");
        try {
            list.setNumbers(stock.getNumbers());
            boolean update = stockService.updateStock(list);
            result = new Result(update, update ? "添加库存成功！" : "添加库存失败！");
        } catch (Exception e) {
            result = new Result(false, "添加库存失败！");
        }
        return result;
    }

    /**
     * 增加库存,减少库存，以及商品的上架下架
     *
     * @param stock
     * @return
     */
    @RequestMapping(value = "/shelf", method = {RequestMethod.POST})
    public @ResponseBody
    Result Shelf(@RequestBody Stock stock) {
        Result result = null;
        if (stock.getGoodsId() == null || stock.getGoodsId().equals("")) {
            return new Result(false, "商品ID不能为空！");
        }
        Stock list = stockService.getStock(stock.getGoodsId());
        if (list == null)
            return new Result(false, "该商品没有库存！");
//        else if (list.get(0).getWetherPurchase() == 1)
//            return new Result(false, "该商品已下架！");
        try {
            list.setWetherPurchase(stock.getWetherPurchase());
            boolean update = stockService.updateStock(list);
            result = new Result(update, update ? "修改商品状态成功！" : "修改商品状态失败！");
        } catch (Exception e) {
            result = new Result(false, "修改商品状态失败！");
        }
        return result;
    }
}

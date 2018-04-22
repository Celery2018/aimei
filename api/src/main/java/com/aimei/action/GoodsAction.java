package com.aimei.action;


import com.aimei.domain.entity.Goods;
import com.aimei.domain.entity.Member;
import com.aimei.service.common.client.ClientService;
import com.aimei.service.common.goods.GoodsService;
import com.aimei.service.common.memberService.MemberService;
import com.aimei.util.LogHelper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by peter on 24/10/2017.
 */
@Controller
@RequestMapping("/goods")
public class GoodsAction {
    private static final Logger logger= LogHelper.log_consoleFile;

    @Resource
    private ClientService clientService;

    @Autowired
    private GoodsService goodsService;

//获取商品列表
    @RequestMapping(value="/getGoodsList",method = {RequestMethod.GET})
    public @ResponseBody List<Goods> listUser(String goodsId) {
        List<Goods> list=goodsService.getGoodsList(goodsId);
        return list;
    }

    @RequestMapping(value="/addGoods",method = {RequestMethod.POST})
    public @ResponseBody String addGoods(@RequestBody Goods goods) {
       boolean add=goodsService.addGoods(goods);
        return String.valueOf(add);
    }

    @RequestMapping(value="/updateGoods",method = {RequestMethod.POST})
    public @ResponseBody String updateGoods(@RequestBody Goods goods) {
        boolean add=goodsService.updateGoods(goods);
        return String.valueOf(add);
    }

    @RequestMapping(value="/deleteGoods",method = {RequestMethod.GET})
    public @ResponseBody String deleteGoods( String goodsId) {
        boolean add=goodsService.deleteGoods(goodsId);
        return String.valueOf(add);
    }
//    @RequestMapping(value = "/query",method = {RequestMethod.POST})
//    public @ResponseBody
//    Client query(HttpServletRequest request, @RequestBody String clientID){
//
//    }
//
//    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
//    public @ResponseBody
//
}

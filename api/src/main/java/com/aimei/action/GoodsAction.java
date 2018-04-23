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
 * 商品类，包含商品的各类操作
 */
@Controller
@RequestMapping("/goods")
public class GoodsAction {
    private static final Logger logger= LogHelper.log_consoleFile;


    @Autowired
    private GoodsService goodsService;

    /**
     * 获取商品列表（当传入商品id时获取高商品的信息，不传时获取所有商品列表）
     * @param goodsId
     * @return
     */
    @RequestMapping(value="/getGoodsList",method = {RequestMethod.GET})
    public @ResponseBody List<Goods> listUser(String goodsId) {
        List<Goods> list=goodsService.getGoodsList(goodsId);
        return list;
    }

    /**
     * 添加商品
     * @param goods
     * @return
     */
    @RequestMapping(value="/addGoods",method = {RequestMethod.POST})
    public @ResponseBody String addGoods(@RequestBody Goods goods) {
       boolean add=goodsService.addGoods(goods);
        return String.valueOf(add);
    }

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    @RequestMapping(value="/updateGoods",method = {RequestMethod.POST})
    public @ResponseBody String updateGoods(@RequestBody Goods goods) {
        boolean add=goodsService.updateGoods(goods);
        return String.valueOf(add);
    }

    /**
     * 删除商品信息
     * @param goodsId
     * @return
     */
    @RequestMapping(value="/deleteGoods",method = {RequestMethod.GET})
    public @ResponseBody String deleteGoods( String goodsId) {
        boolean add=goodsService.deleteGoods(goodsId);
        return String.valueOf(add);
    }
}

package com.aimei.action;


import com.aimei.dao.domain.dto.Result;
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
    public @ResponseBody
    Result listUser(String goodsId) {
        List<Goods> list=goodsService.getGoodsList(goodsId);
        return new Result(true,list);
    }

    /**
     * 添加商品
     * @param goods
     * @return
     */
    @RequestMapping(value="/addGoods",method = {RequestMethod.POST})
    public @ResponseBody Result addGoods(@RequestBody Goods goods) {
        Result result=null;
        try {
            List<Goods> goodss=goodsService.getGoodsByName(goods.getGoodsName());
            if(goodss!=null&&goodss.size()>0)
                result=new Result(false,"该商品已存在");
            else {
                boolean add=goodsService.addGoods(goods);
                result=new Result(add,add?"商品添加成功":"商品添加失败");
            }
        }catch (Exception e){
            result=new Result(false ,"商品添加失败");
        }
        return result;
    }

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    @RequestMapping(value="/updateGoods",method = {RequestMethod.POST})
    public @ResponseBody Result updateGoods(@RequestBody Goods goods) {
        Result result=null;
        try {
            boolean add=goodsService.updateGoods(goods);
            result=new Result(add,add?"更新成功！":"更新失败");
        }catch (Exception e){
            result=new Result(false,"更新失败");
        }

        return result;
    }

    /**
     * 删除商品信息
     * @param goodsId
     * @return
     */
    @RequestMapping(value="/deleteGoods",method = {RequestMethod.GET})
    public @ResponseBody Result deleteGoods( String goodsId) {
        Result result=null;
        try {
            boolean add=goodsService.deleteGoods(goodsId);
            result=new Result(add,add?"删除成功！":"删除失败");
        }catch (Exception e){
            result=new Result(false,"删除失败");
        }
        return result;
    }
}

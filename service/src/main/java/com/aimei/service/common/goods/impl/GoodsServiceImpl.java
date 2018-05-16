package com.aimei.service.common.goods.impl;

import com.aimei.dao.goods.GoodsDao;
import com.aimei.dao.stock.StockDao;
import com.aimei.domain.entity.Goods;
import com.aimei.domain.entity.Stock;
import com.aimei.service.common.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by peter on 25/10/2017.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao GoodsDao;

    @Autowired
    private StockDao stockDao;


    @Override
    public List<com.aimei.domain.entity.Goods> getGoodsList(String GoodsId) {
        return GoodsDao.getGoodsList(GoodsId);
    }

    @Override
    public boolean addGoods(com.aimei.domain.entity.Goods goods) {
        String goodsId = String.valueOf(new Date().getTime());
        Stock stock = new Stock();
        stock.setGoodsId(goods.getGoodsId());
        stock.setGoodsId(goodsId);
        stock.setNumbers("1");
        stock.setWetherPurchase(0);
        stock.setPurchaseTime(new Date());
        boolean addStock = stockDao.addStock(stock);
        if (addStock) {
            goods.setPurchaseDate(new Date());
            goods.setGoodsId(goodsId);
            return GoodsDao.addGoods(goods);
        } else
            return false;
    }

    @Override
    public boolean updateGoods(com.aimei.domain.entity.Goods Goods) {
        return GoodsDao.updateGoods(Goods);
    }

    @Override
    public boolean deleteGoods(String goodsId) {
        boolean deleteStock = stockDao.deleteStock(goodsId);
        if (deleteStock)
            return GoodsDao.deleteGoods(goodsId);
        else
            return false;
    }

    @Override
    public List<Goods> getGoodsByName(String goodsName) {
        return GoodsDao.getGoodsByName(goodsName);
    }


}

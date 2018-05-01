package com.aimei.service.common.goods.impl;

import com.aimei.dao.GoodsDao;
import com.aimei.domain.entity.Goods;
import com.aimei.service.common.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by peter on 25/10/2017.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao GoodsDao;


    @Override
    public List<com.aimei.domain.entity.Goods> getGoodsList(String GoodsId) {
        return GoodsDao.getGoodsList(GoodsId);
    }

    @Override
    public boolean addGoods(com.aimei.domain.entity.Goods Goods) {
        return GoodsDao.addGoods(Goods);
    }

    @Override
    public boolean updateGoods(com.aimei.domain.entity.Goods Goods) {
        return GoodsDao.updateGoods(Goods);
    }

    @Override
    public boolean deleteGoods(String GoodsId) {
        return GoodsDao.deleteGoods(GoodsId);
    }

    @Override
    public List<Goods> getGoodsByName(String goodsName) {
        return null;
    }


}

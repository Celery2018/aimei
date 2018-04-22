package com.aimei.dao;

import com.aimei.domain.entity.Goods;

import java.util.List;

public interface GoodsDao {

    List<Goods> getGoodsList(String goodsId);
    boolean addGoods(Goods goods);
    boolean updateGoods(Goods goods);
    boolean deleteGoods(String goodId);
}

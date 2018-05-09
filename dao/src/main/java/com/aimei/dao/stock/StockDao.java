package com.aimei.dao.stock;

import com.aimei.domain.entity.Goods;
import com.aimei.domain.entity.Stock;

import java.util.List;

public interface StockDao {

    List<Stock> getStockList(String goodsId);
    boolean addGoods(Goods goods);
    boolean updateStock(Stock stock);
    boolean deleteGoods(String goodId);
    List<Goods> getGoodsByName(String goodsName);
}

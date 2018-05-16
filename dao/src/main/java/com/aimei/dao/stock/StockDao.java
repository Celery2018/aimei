package com.aimei.dao.stock;

import com.aimei.domain.entity.Goods;
import com.aimei.domain.entity.Stock;

import java.util.List;

public interface StockDao {

    Stock getStock(String goodsId);
    boolean addStock(Stock stock);
    boolean updateStock(Stock stock);
    boolean deleteStock(String goodId);
}

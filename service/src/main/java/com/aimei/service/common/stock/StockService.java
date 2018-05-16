package com.aimei.service.common.stock;

import com.aimei.domain.entity.Member;
import com.aimei.domain.entity.Stock;

import java.util.List;

/**
 * Created by peter on 25/10/2017.
 */

public interface StockService {
    Stock getStock(String goodsId);
    boolean updateStock(Stock stock);
    boolean addStock(Stock stock);
    boolean deleteStock(String stockId);
}

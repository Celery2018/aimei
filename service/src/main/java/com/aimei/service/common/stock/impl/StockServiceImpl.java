package com.aimei.service.common.stock.impl;

import com.aimei.dao.member.MemberDao;
import com.aimei.dao.stock.StockDao;
import com.aimei.domain.entity.Member;
import com.aimei.domain.entity.Stock;
import com.aimei.service.common.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by peter on 25/10/2017.
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;


    @Override
    public Stock getStock(String goodsId) {
        return stockDao.getStock(goodsId);
    }


    @Override
    public boolean updateStock(Stock stock) {
        return stockDao.updateStock(stock);
    }

    @Override
    public boolean addStock(Stock stock) {
        return stockDao.addStock(stock);
    }

    @Override
    public boolean deleteStock(String stockId) {
        return stockDao.deleteStock(stockId);
    }


}

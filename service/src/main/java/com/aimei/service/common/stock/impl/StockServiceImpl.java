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
    public List<Stock> getStockLost(String goodsId) {
        return stockDao.getStockList(goodsId);
    }


    @Override
    public boolean updateStock(Stock stock) {
        return stockDao.updateStock(stock);
    }




}

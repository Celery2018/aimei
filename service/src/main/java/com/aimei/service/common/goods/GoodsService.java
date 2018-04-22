package com.aimei.service.common.goods;

import com.aimei.domain.entity.Goods;
import com.aimei.domain.entity.Member;

import java.util.List;

/**
 * Created by peter on 25/10/2017.
 */

public interface GoodsService {
    List<Goods> getGoodsList(String goodsId);
    boolean addGoods(Goods goods);
    boolean updateGoods(Goods goods);
    boolean deleteGoods(String goodsId);
}

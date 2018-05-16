package com.aimei.service.common.shoppingCar.impl;

import com.aimei.dao.goods.GoodsDao;
import com.aimei.dao.member.MemberDao;
import com.aimei.dao.shoppingCar.ShoppingCarDao;
import com.aimei.domain.entity.Goods;
import com.aimei.domain.entity.Member;
import com.aimei.domain.entity.ShoppingCar;
import com.aimei.service.common.shoppingCar.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
    @Autowired
    ShoppingCarDao shoppingCarDao;
    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<ShoppingCar> getShoppingCarList(String memberId) {
        List<ShoppingCar> shoppingCars = shoppingCarDao.getShoppingCarList(memberId);
        for (ShoppingCar shoppingCar : shoppingCars) {
            List<Goods> goods = goodsDao.getGoodsList(shoppingCar.getGoodsId());
            if (goods != null && goods.size() > 0)
                shoppingCar.setGoods(goods.get(0));
        }
        return shoppingCars;
    }

    @Override
    public boolean addShopping(ShoppingCar shoppingCar) {
        return shoppingCarDao.addShopping(shoppingCar);
    }

    @Override
    public boolean updateShoppingCar(ShoppingCar shoppingCar) {
        return shoppingCarDao.updateShoppingCar(shoppingCar);
    }

    @Override
    public boolean deleteShoppingCar(String id) {
        return shoppingCarDao.deleteShoppingCar(id);
    }

    @Override
    public boolean clearShoppingCar(String memberId) {
        return shoppingCarDao.clearShoppingCar(memberId);
    }
}

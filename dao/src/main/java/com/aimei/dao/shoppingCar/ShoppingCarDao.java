package com.aimei.dao.shoppingCar;


import com.aimei.domain.entity.Member;
import com.aimei.domain.entity.ShoppingCar;

import java.util.List;

public interface ShoppingCarDao {
    List<ShoppingCar> getShoppingCarList(String memberId);
    boolean addShopping(ShoppingCar shoppingCar);
    boolean updateShoppingCar(ShoppingCar shoppingCar);
    boolean deleteShoppingCar(String id);
    boolean clearShoppingCar(String memberId);
    ShoppingCar getShoppingCar(String id);
}

package com.aimei.dao.shoppingCar;

import com.aimei.domain.entity.Member;
import com.aimei.domain.entity.ShoppingCar;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.aimei.util.DataBaseHelper.doConnect;

@Component
public class ShoppingCarDaoImpl implements ShoppingCarDao {


    public static void main(String[] args) {
    }


    /**
     * 获取购物车数据
     *
     * @param memberId
     * @return
     */
    public static List<ShoppingCar> getShoppingCarData(String memberId) {
        try {
            Connection con = doConnect();
            if (con == null)
                return null;
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = null;
            sql = "select * from shopping_car WHERE memberId=" + "'" + memberId + "'";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            List<ShoppingCar> list = getMemberData(rs);
            rs.close();
            con.close();
            return list;
        } catch (Exception e) {
            System.out.println("抓取错误!");
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！！");
        }
        return null;
    }

    /**
     * 获取单个购物车数据
     *
     * @param id
     * @return
     */
    public static ShoppingCar getShoppingData(String id) {
        try {
            Connection con = doConnect();
            if (con == null)
                return null;
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = null;
            sql = "select * from shopping_car WHERE id=" + "'" + id + "'";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            List<ShoppingCar> list = getMemberData(rs);
            rs.close();
            con.close();
            if (list != null && list.size() > 0)
                return list.get(0);
            else
                return null;
        } catch (Exception e) {
            System.out.println("抓取错误!");
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！！");
        }
        return null;
    }


    /**
     * 读取从数据库读取到的数据并返回一个集合
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private static List<ShoppingCar> getMemberData(ResultSet rs) throws SQLException {
        List<ShoppingCar> list = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("id");
            String goodsId = rs.getString("goodsId");
            int number = rs.getInt("number");
            String memberId = rs.getString("memberId");
            ShoppingCar shoppingCar = new ShoppingCar();
            shoppingCar.setGoodsId(goodsId);
            shoppingCar.setId(id);
            shoppingCar.setNumber(number);
            shoppingCar.setMemberId(memberId);
            list.add(shoppingCar);
        }
        return list;
    }


    /**
     * 新增一个member数据
     *
     * @param shoppingCar
     * @return
     */
    public static boolean addShoppingCars(ShoppingCar shoppingCar) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            //预处理添加数据，其中有两个参数--“？”
            psql = con.prepareStatement("insert into shopping_car (goodsId,number,memberId) "
                    + "values(?,?,?)");
            psql.setString(1, shoppingCar.getGoodsId());
            psql.setInt(2, shoppingCar.getNumber());
            psql.setString(3, shoppingCar.getMemberId());
            psql.executeUpdate();
            con.isClosed();
            System.out.println("插入数据成功");
            return true;
        } catch (Exception e) {
            System.out.println("错误");
        }
        return false;
    }

    /**
     * memberId更新数据
     * 根据
     *
     * @param shoppingCar
     * @return
     */
    public static boolean updateShoppingCars(ShoppingCar shoppingCar) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            psql = con.prepareStatement("update shopping_car set goodsId= ? , number=?, memberId=? where id= ?");
            psql.setString(1, shoppingCar.getGoodsId());
            psql.setInt(2, shoppingCar.getNumber());
            psql.setString(3, shoppingCar.getMemberId());
            psql.setString(4, shoppingCar.getId());
            psql.executeUpdate();
            con.isClosed();
            System.out.println("更新数据成功");
            return true;
        } catch (Exception e) {
            System.out.println("错误");
        }
        return false;
    }

    /**
     * 根据memberId删除一条数据
     *
     * @param id
     * @return
     */
    public static boolean deleteShoppingCars(String id) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            psql = con.prepareStatement("delete from shopping_car where id=?");
            psql.setString(1, id);
            psql.executeUpdate();
            con.isClosed();
            System.out.println("删除数据成功");
            return true;
        } catch (Exception e) {
            System.out.println("错误");
        }
        return false;
    }

    /**
     * 根据memberId删除一条数据
     *
     * @param memberId
     * @return
     */
    public static boolean clearShoppingCars(String memberId) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            psql = con.prepareStatement("delete from shopping_car where memberId=?");
            psql.setString(1, memberId);
            psql.executeUpdate();
            con.isClosed();
            System.out.println("删除数据成功");
            return true;
        } catch (Exception e) {
            System.out.println("错误");
        }
        return false;
    }

    @Override
    public List<ShoppingCar> getShoppingCarList(String memberId) {
        return getShoppingCarData(memberId);
    }

    @Override
    public boolean addShopping(ShoppingCar shoppingCar) {
        return addShoppingCars(shoppingCar);
    }

    @Override
    public boolean updateShoppingCar(ShoppingCar shoppingCar) {
        return updateShoppingCars(shoppingCar);
    }

    @Override
    public boolean deleteShoppingCar(String id) {
        return deleteShoppingCars(id);
    }

    @Override
    public boolean clearShoppingCar(String memberId) {
        return clearShoppingCars(memberId);
    }

    @Override
    public ShoppingCar getShoppingCar(String id) {
        return getShoppingData(id);
    }
}

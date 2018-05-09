package com.aimei.dao.goods;

import com.aimei.domain.entity.Goods;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.aimei.util.DataBaseHelper.doConnect;

@Component
public class GoodsDaoImpl implements GoodsDao {



    public static void main(String[] args) {

        //删除
        boolean b=deleteGoodsData("2");
    }

    public static List<Goods> getGoods(String goodsId) {
        try {
            Connection con = doConnect();
            if (con == null)
                return null;
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = null;
            if (goodsId == null || goodsId == "") {
                sql = "select * from goods";
            } else {
                sql = "select * from goods WHERE goodsId =" + goodsId;
            }
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            List<Goods> list = new ArrayList<>();
            while (rs.next()) {
                String goodsid = rs.getString("goodsId");
                String stockId = rs.getString("stockId");
                String goodsTypeId = rs.getString("goodsTypeId");
                String goodsName = rs.getString("goodsName");
                String goodsComment = rs.getString("goodsComment");
                Double price = rs.getDouble("price");
                Date purchaseDate = rs.getDate("purchaseDate");
                Goods userEntity = new Goods();
                userEntity.setGoodsId(goodsid);
                userEntity.setStockId(stockId);
                userEntity.setGoodsTypeId(goodsTypeId);
                userEntity.setGoodsName(goodsName);
                userEntity.setGoodsComment(goodsComment);
                userEntity.setPrice(price);
                userEntity.setPurchaseDate(purchaseDate);
                list.add(userEntity);
            }
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

    public static List<Goods> getGoodsByNames(String goodsName) {
        try {
            Connection con = doConnect();
            if (con == null)
                return null;
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from goods WHERE goodsId =" +  "'"+goodsName+"'";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            List<Goods> list = new ArrayList<>();
            while (rs.next()) {
                String goodsid = rs.getString("goodsId");
                String stockId = rs.getString("stockId");
                String goodsTypeId = rs.getString("goodsTypeId");
                String goodsName1 = rs.getString("goodsName");
                String goodsComment = rs.getString("goodsComment");
                Double price = rs.getDouble("price");
                Date purchaseDate = rs.getDate("purchaseDate");
                Goods userEntity = new Goods();
                userEntity.setGoodsId(goodsid);
                userEntity.setStockId(stockId);
                userEntity.setGoodsTypeId(goodsTypeId);
                userEntity.setGoodsName(goodsName1);
                userEntity.setGoodsComment(goodsComment);
                userEntity.setPrice(price);
                userEntity.setPurchaseDate(purchaseDate);
                list.add(userEntity);
            }
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




    public static  boolean addGoodsData (Goods goods){
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con=doConnect();
            //预处理添加数据，其中有两个参数--“？”
            psql = con.prepareStatement("insert into goods (goodsId,stockId,goodsTypeId,goodsName,goodsComment,price,purchaseDate) "
                    + "values(?,?,?,?,?,?,?)");
                psql.setString(1, goods.getGoodsId());
                psql.setString(2, goods.getStockId());
                psql.setString(3, goods.getGoodsTypeId());
                psql.setString(4, goods.getGoodsName());
                psql.setString(5, goods.getGoodsComment());
                psql.setDouble(6, goods.getPrice());
                psql.setDate(7, (java.sql.Date) goods.getPurchaseDate());
                psql.executeUpdate();
            con.isClosed();
            System.out.println("插入数据成功");
            return true;
        }catch (Exception e){
            System.out.println("错误");
        }
        return false;
    }


    public static  boolean updateGoodsData (Goods goods){
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con=doConnect();
            psql = con.prepareStatement("update goods set goodsId = ? ,stockId= ? , goodsTypeId=?, goodsName=?, goodsComment=?, price=?,purchaseDate=? where goodsId = ?");
            psql.setString(1, goods.getGoodsId());
            psql.setString(2, goods.getStockId());
            psql.setString(3, goods.getGoodsTypeId());
            psql.setString(4, goods.getGoodsName());
            psql.setString(5, goods.getGoodsComment());
            psql.setDouble(6, goods.getPrice());
            psql.setDate(7, (java.sql.Date) goods.getPurchaseDate());
            psql.setString(8,goods.getGoodsId());
            psql.executeUpdate();
            con.isClosed();
            System.out.println("更新数据成功");
            return true;
        }catch (Exception e){
            System.out.println("错误");
        }
        return false;
    }

    public static  boolean deleteGoodsData (String goodsId){
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con=doConnect();
            psql = con.prepareStatement("delete from goods where goodsId=?");
            psql.setString(1, goodsId);

            psql.executeUpdate();
            con.isClosed();
            System.out.println("删除数据成功");
            return true;
        }catch (Exception e){
            System.out.println("错误");
        }
        return false;
    }

    @Override
    public List<Goods> getGoodsList(String goodsId) {
        return getGoods(goodsId);
    }

    @Override
    public boolean addGoods(Goods goods) {
        return addGoodsData(goods);
    }

    @Override
    public boolean updateGoods(Goods goods) {
        return updateGoodsData(goods);
    }

    @Override
    public boolean deleteGoods(String goodsId) {
        return deleteGoodsData(goodsId);
    }

    @Override
    public List<Goods> getGoodsByName(String goodsName) {
        return getGoodsByNames(goodsName);
    }
}

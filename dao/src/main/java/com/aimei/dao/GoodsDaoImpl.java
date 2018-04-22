package com.aimei.dao;

import com.aimei.domain.entity.Goods;
import com.aimei.domain.entity.Member;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class GoodsDaoImpl implements GoodsDao {

    private static String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    private static String url = "jdbc:mysql://localhost:3306/aimei?useUnicode=true&amp;characterEncoding=UTF8";
    //MySQL配置时的用户名
    private static String user = "root";
    //MySQL配置时的密码
    private static String password = "newpassword";

    public static void main(String[] args) {
//        List<Goods> GoodsList = getGoods(null);
//        for (Goods userEntity : GoodsList) {
//            System.out.println(userEntity.getGoodsId() + "\t" + userEntity.getGoodsName() + "\t" + userEntity.getPrice());
//        }
//        List<Goods> list1 = getGoods("1123");
//        for (Goods userEntity : list1) {
//            System.out.println(userEntity.getGoodsId() + "\t" + userEntity.getGoodsName() + "\t" + userEntity.getPrice());
//        }
//        //更新
//        Goods goods1=new Goods();
//        goods1.setGoodsId("2");
//        goods1.setGoodsName("xiao12365");
//        goods1.setPrice(100.00);
//        goods1.setStockId("2");
//        goods1.setGoodsTypeId("2");
//        boolean b=updateGoodsData(goods1);
//        System.out.println(b);

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


    public static Connection doConnect() {
        Connection con;
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                return con;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
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
}

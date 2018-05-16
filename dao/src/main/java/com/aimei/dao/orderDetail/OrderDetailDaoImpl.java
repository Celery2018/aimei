package com.aimei.dao.orderDetail;

import com.aimei.domain.entity.Goods;
import com.aimei.domain.entity.Order;
import com.aimei.domain.entity.OrderDetail;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.aimei.util.DataBaseHelper.doConnect;

@Component
public class OrderDetailDaoImpl implements OrderDetailDao {


    public static void main(String[] args) {

    }


    /**
     * 获取购物车数据
     *
     * @param orderId
     * @return
     */
    public static List<Goods> getOrderDetails(String orderId) {
        try {
            Connection con = doConnect();
            if (con == null)
                return null;
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = null;
            sql = "select goods.* ,order_detail.number as number from goods left join order_detail on goods.goodsId = order_detail.goodsId" +
                    " WHERE order_detail.orderId=" + "'" + orderId + "'";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            List<Goods> list = getMemberData(rs);
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
     * 读取从数据库读取到的数据并返回一个集合
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private static List<Goods> getMemberData(ResultSet rs) throws SQLException {
        List<Goods> list = new ArrayList<>();
        while (rs.next()) {
            String goodsid = rs.getString("goodsId");
            String stockId = rs.getString("stockId");
            String goodsTypeId = rs.getString("goodsTypeId");
            String goodsName = rs.getString("goodsName");
            String goodsComment = rs.getString("goodsComment");
            Double price = rs.getDouble("price");
            Date purchaseDate = rs.getDate("purchaseDate");
            int number=rs.getInt("number");
            Goods userEntity = new Goods();
            userEntity.setGoodsId(goodsid);
            userEntity.setStockId(stockId);
            userEntity.setGoodsTypeId(goodsTypeId);
            userEntity.setGoodsName(goodsName);
            userEntity.setGoodsComment(goodsComment);
            userEntity.setPrice(price);
            userEntity.setPurchaseDate(purchaseDate);
            userEntity.setNumber(number);
            list.add(userEntity);
        }
        return list;
    }


    /**
     * 新增订单详情
     *
     * @param orderDetail
     * @return
     */
    public static boolean addOrderDetails(OrderDetail orderDetail) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            //预处理添加数据，其中有两个参数--“？”
            psql = con.prepareStatement("insert into order_detail (goodsId,orderId,number) "
                    + "values(?,?,?)");
            psql.setString(1,orderDetail.getGoodsId());
            psql.setString(2,orderDetail.getOrderId());
            psql.setInt(3, orderDetail.getNumber());
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
     * 根据memberId删除一条数据
     *
     * @param orderId
     * @return
     */
    public static boolean deleteOrderDeatils(String orderId) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            psql = con.prepareStatement("delete from order_detail where orderId=?");
            psql.setString(1, orderId);
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
    public List<Goods> getOrderDetail(String orderId) {
        return getOrderDetails(orderId);
    }

    @Override
    public boolean addOrderDetail(OrderDetail orderDetail) {
        return addOrderDetails(orderDetail);
    }

    @Override
    public boolean deleteOrderDetail(String orderId) {
        return deleteOrderDeatils(orderId);
    }
}

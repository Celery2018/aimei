package com.aimei.dao.order;

import com.aimei.domain.entity.Order;
import com.aimei.domain.entity.ShoppingCar;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.aimei.util.DataBaseHelper.doConnect;

@Component
public class OrderDaoImpl implements OrderDao {


    public static void main(String[] args) {
    }


    /**
     * 获取购物车数据
     *
     * @param memberId
     * @return
     */
    public static List<Order> getOrders(String memberId) {
        try {
            Connection con = doConnect();
            if (con == null)
                return null;
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = null;
            sql = "select * from orders WHERE memberId=" + "'" + memberId + "'";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            List<Order> list = getMemberData(rs);
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
    private static List<Order> getMemberData(ResultSet rs) throws SQLException {
        List<Order> list = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString("id");
            Date orderGenDate = rs.getDate("orderGenDate");
            String memberName = rs.getString("memberName");
            String phone = rs.getString("phone");
            String address = rs.getString("address");
            String email = rs.getString("email");
            int status = rs.getInt("status");
            double price=rs.getDouble("price");
            String memberId = rs.getString("memberId");
            Order order = new Order();
            order.setId(id);
            order.setOrderGenDate(orderGenDate);
            order.setMemberName(memberName);
            order.setMemberId(memberId);
            order.setAddress(address);
            order.setPhone(phone);
            order.setStatus(status);
            order.setEmail(email);
            order.setPrice(price);
            list.add(order);
        }
        return list;
    }


    /**
     * 新增一个member数据
     *
     * @param order
     * @return
     */
    public static boolean addOrders(Order order) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            //预处理添加数据，其中有两个参数--“？”
            psql = con.prepareStatement("insert into orders (id,orderGenDate,memberName,phone,address,email,status,memberId,price) "
                    + "values(?,?,?,?,?,?,?,?,?)");
            psql.setString(1, order.getId());
            psql.setDate(2, new java.sql.Date(order.getOrderGenDate().getTime()));
            psql.setString(3, order.getMemberName());
            psql.setString(4, order.getPhone());
            psql.setString(5, order.getAddress());
            psql.setString(6, order.getEmail());
            psql.setInt(7, order.getStatus());
            psql.setString(8, order.getMemberId());
            psql.setDouble(9,order.getPrice());

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
     * @param order
     * @return
     */
    public static boolean updateOrders(Order order) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            psql = con.prepareStatement("update orders set status= ? where id = ?");
            psql.setInt(1, order.getStatus());
            psql.setString(2, order.getId());
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
    public static boolean deleteOrders(String id) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            psql = con.prepareStatement("delete from orders where id=?");
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
    public List<Order> getOrderList(String memberId) {
        return getOrders(memberId);
    }

    @Override
    public boolean addOrder(Order order) {
        return addOrders(order);
    }

    @Override
    public boolean updateOrder(Order order) {
        return updateOrders(order);
    }

    @Override
    public boolean deleteOrder(String id) {
        return deleteOrders(id);
    }
}

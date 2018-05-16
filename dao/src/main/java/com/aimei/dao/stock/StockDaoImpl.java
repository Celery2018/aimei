package com.aimei.dao.stock;

import com.aimei.domain.entity.Goods;
import com.aimei.domain.entity.Stock;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.aimei.util.DataBaseHelper.doConnect;

@Component
public class StockDaoImpl implements StockDao {


    public static void main(String[] args) {
//        Stock stock = new Stock();
//        stock.setGoodsId("12354");
//        stock.setMemberId("27");
//        stock.setNumbers("50");
//        stock.setPurchaseTime(new Date());
//        stock.setWetherPurchase(1);
//        addStockData(stock);
//        deleteStockData("1");
//        List<Stock> stocks = getStockByGoodsId("12354");
//        for (Stock stock : stocks) {
//            System.out.println(stock.getId());
//        }
    }

    /**
     * 根据商品ID来获取库存信息
     *
     * @param goodsId
     * @return
     */
    public static Stock getStockByGoodsId(String goodsId) {
        try {
            Connection con = doConnect();
            if (con == null)
                return null;
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = null;
            sql = "select * from stock WHERE goodsId =" + goodsId;
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            List<Stock> list = new ArrayList<>();
            while (rs.next()) {
                String goodsid = rs.getString("goodsId");
                String stockId = rs.getString("stockId");
                String memberId = rs.getString("memberId");
                String numbers = rs.getString("numbers");
                Date purchaseTime = rs.getDate("purchaseTimes");
                int wetherPurchase = rs.getInt("wetherPurchase");
                Stock stock = new Stock();
                stock.setGoodsId(goodsid);
                stock.setId(stockId);
                stock.setMemberId(memberId);
                stock.setNumbers(numbers);
                stock.setPurchaseTime(purchaseTime);
                stock.setWetherPurchase(wetherPurchase);
                list.add(stock);
            }
            rs.close();
            con.close();
            if (list.size() > 0)
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
     * 新增一个库存
     *
     * @param stock
     * @return
     */
    public static boolean addStockData(Stock stock) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            //预处理添加数据，其中有两个参数--“？”
            psql = con.prepareStatement("insert into stock (goodsId,memberId,numbers,purchaseTimes,wetherPurchase) "
                    + "values(?,?,?,?,?)");
            psql.setString(1, stock.getGoodsId());
            psql.setString(2, stock.getMemberId());
            psql.setString(3, stock.getNumbers());
            psql.setDate(4, new java.sql.Date(stock.getPurchaseTime().getTime()));
            psql.setInt(5, stock.getWetherPurchase());
            psql.executeUpdate();
            con.isClosed();
            System.out.println("插入数据成功");
            return true;
        } catch (Exception e) {
            System.out.println("错误");
        }
        return false;
    }


    public static boolean updateStockData(Stock stock) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            psql = con.prepareStatement("update stock set goodsId = ? ,memberId= ? , numbers=?, purchaseTimes=?, wetherPurchase=? where stockId = ?");
            psql.setString(1, stock.getGoodsId());
            psql.setString(2, stock.getMemberId());
            psql.setString(3, stock.getNumbers());
            psql.setDate(4, (java.sql.Date) stock.getPurchaseTime());
            psql.setInt(5, stock.getWetherPurchase());
            psql.setString(6, stock.getId());
            psql.executeUpdate();
            con.isClosed();
            System.out.println("更新数据成功");
            return true;
        } catch (Exception e) {
            System.out.println("错误");
        }
        return false;
    }

    public static boolean deleteStockData(String stockId) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            psql = con.prepareStatement("delete from stock where stockId=?");
            psql.setString(1, stockId);

            psql.executeUpdate();
            con.isClosed();
            System.out.println("删除数据成功");
            return true;
        } catch (Exception e) {
            System.out.println("错误");
        }
        return false;
    }

    public static boolean deleteStockByGoodsId(String goodsId) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            psql = con.prepareStatement("delete from stock where goodsId=?");
            psql.setString(1, goodsId);

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
    public Stock getStock(String goodsId) {
        return getStockByGoodsId(goodsId);
    }

    @Override
    public boolean addStock(Stock stock) {
        return addStockData(stock);
    }

    @Override
    public boolean updateStock(Stock stock) {
        return updateStockData(stock);
    }

    @Override
    public boolean deleteStock(String goodsId) {
        return deleteStockByGoodsId(goodsId);
    }

}

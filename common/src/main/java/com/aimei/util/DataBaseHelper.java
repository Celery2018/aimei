package com.aimei.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHelper {

    private static String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    private static String url = "jdbc:mysql://localhost:3306/aimei?useUnicode=true&amp;characterEncoding=UTF8";
    //MySQL配置时的用户名
    private static String user = "root";
    //MySQL配置时的密码
//    private static String password = "newpassword";

    private static String password = "root";
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
}

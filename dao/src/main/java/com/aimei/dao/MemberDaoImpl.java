package com.aimei.dao;

import com.aimei.domain.entity.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MemberDaoImpl implements MemberDao {
    @Override
    public List<Member> getMemberList(String memberId) {
        return getMembers(memberId);
    }

    @Override
    public boolean addMember(Member member) {
        return addMembers(member);
    }

    @Override
    public boolean updateMember(Member member) {
        return updateMembers(member);
    }

    @Override
    public boolean deleteMember(String memberId) {
        return deleteMembers(memberId);
    }


    private static String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    private static String url = "jdbc:mysql://localhost:3306/aimei?useUnicode=true&amp;characterEncoding=UTF8";
    //MySQL配置时的用户名
    private static String user = "root";
    //MySQL配置时的密码
    private static String password = "newpassword";

    public static void main(String[] args) {
//        List<Member> memberList = getMembers(null);
//        for (Member userEntity : memberList) {
//            System.out.println(userEntity.getMerberId() + "\t" + userEntity.getName() + "\t" + userEntity.getRealname());
//        }
//        List<Member> list1 = getMembers("1");
//        for (Member userEntity : list1) {
//            System.out.println(userEntity.getMerberId() + "\t" + userEntity.getName() + "\t" + userEntity.getRealname());
//        }
        //更新
//        Member member1=new Member();
//        member1.setMerberId("2");
//        member1.setName("xiao磊磊");
//        member1.setSex("female");
//        boolean b=updateMembers(member1);
//        System.out.println(b);

        //删除
        boolean b=deleteMembers("2");
    }

    public static List<Member> getMembers(String memberId) {
        try {
            Connection con = doConnect();
            if (con == null)
                return null;
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = null;
            if (memberId == null || memberId == "") {
                sql = "select * from member";
            } else {
                sql = "select * from member WHERE memberId =" + memberId;
            }
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            List<Member> list = new ArrayList<>();
            while (rs.next()) {
                String merberId = rs.getString("memberId");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String realname = rs.getString("realname");
                String sex = rs.getString("sex");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Date createTime = rs.getDate("createTime");
                Member userEntity = new Member();
                userEntity.setMerberId(merberId);
                userEntity.setName(name);
                userEntity.setPassword(password);
                userEntity.setRealname(realname);
                userEntity.setSex(sex);
                userEntity.setPhone(phone);
                userEntity.setEmail(email);
                userEntity.setAddress(address);
                userEntity.setCreateTime(createTime);
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

    public static  boolean addMembers (Member member){
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con=doConnect();
            //预处理添加数据，其中有两个参数--“？”
            psql = con.prepareStatement("insert into member (memberId,name,password,realName,sex,phone,email,address,createTime) "
                    + "values(?,?,?,?,?,?,?,?,?)");
                psql.setString(1, member.getMerberId());
                psql.setString(2, member.getName());
                psql.setString(3, member.getPassword());
                psql.setString(4, member.getRealname());
                psql.setString(5, member.getSex());
                psql.setString(6, member.getPhone());
                psql.setString(7, member.getEmail());
                psql.setString(8, member.getAddress());
                psql.setDate(9, (java.sql.Date) member.getCreateTime());
                psql.executeUpdate();
            con.isClosed();
            System.out.println("插入数据成功");
            return true;
        }catch (Exception e){
            System.out.println("错误");
        }
        return false;
    }


    public static  boolean updateMembers (Member member){
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con=doConnect();
            psql = con.prepareStatement("update member set name = ? ,password= ? , realName=?, sex=?, phone=?, email=?,address=?,createTime=? where merberId = ?");
            psql.setString(1, member.getName());
            psql.setString(2, member.getPassword());
            psql.setString(3, member.getRealname());
            psql.setString(4, member.getSex());
            psql.setString(5, member.getPhone());
            psql.setString(6, member.getEmail());
            psql.setString(7, member.getAddress());
            psql.setDate(8, (java.sql.Date) member.getCreateTime());
            psql.setString(9,member.getMerberId());
            psql.executeUpdate();
            con.isClosed();
            System.out.println("更新数据成功");
            return true;
        }catch (Exception e){
            System.out.println("错误");
        }
        return false;
    }

    public static  boolean deleteMembers (String memberId){
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con=doConnect();
            psql = con.prepareStatement("delete from member where merberId=?");
            psql.setString(1, memberId);

            psql.executeUpdate();
            con.isClosed();
            System.out.println("删除数据成功");
            return true;
        }catch (Exception e){
            System.out.println("错误");
        }
        return false;
    }
}

package com.aimei.dao.member;

import com.aimei.domain.entity.Member;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.aimei.util.DataBaseHelper.doConnect;

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

    @Override
    public List<Member> getMemberByName(String memberName) {
        List<Member> list = getMembersByName(memberName);
        return list;
    }


    public static void main(String[] args) {

        //删除
        boolean b = deleteMembers("2");
    }


    /**
     * 获取member数据
     *
     * @param memberName
     * @return
     */
    public static List<Member> getMembersByName(String memberName) {
        try {
            Connection con = doConnect();
            if (con == null)
                return null;
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = null;
            sql = "select * from member WHERE name=" + "'"+memberName+"'";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            List<Member> list = getMemberData(rs);
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
     * 获取member数据
     *
     * @param memberId
     * @return
     */
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
            List<Member> list = getMemberData(rs);
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
    private static List<Member> getMemberData(ResultSet rs) throws SQLException {
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
        return list;
    }


    /**
     * 新增一个member数据
     *
     * @param member
     * @return
     */
    public static boolean addMembers(Member member) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
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
        } catch (Exception e) {
            System.out.println("错误");
        }
        return false;
    }

    /**
     * 根据memberId更新数据
     *
     * @param member
     * @return
     */
    public static boolean updateMembers(Member member) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            psql = con.prepareStatement("update member set name = ? ,password= ? , realName=?, sex=?, phone=?, email=?,address=?,createTime=? where merberId = ?");
            psql.setString(1, member.getName());
            psql.setString(2, member.getPassword());
            psql.setString(3, member.getRealname());
            psql.setString(4, member.getSex());
            psql.setString(5, member.getPhone());
            psql.setString(6, member.getEmail());
            psql.setString(7, member.getAddress());
            psql.setDate(8, (java.sql.Date) member.getCreateTime());
            psql.setString(9, member.getMerberId());
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
     * @param memberId
     * @return
     */
    public static boolean deleteMembers(String memberId) {
        PreparedStatement psql;
        ResultSet res;
        try {
            Connection con = doConnect();
            psql = con.prepareStatement("delete from member where merberId=?");
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
}

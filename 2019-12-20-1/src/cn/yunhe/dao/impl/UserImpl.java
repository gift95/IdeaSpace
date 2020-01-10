package cn.yunhe.dao.impl;

import cn.yunhe.beans.User;
import cn.yunhe.dao.UserDao;
import cn.yunhe.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户数据查询具体实现类
 *
 * @author Administrator
 */
public class UserImpl implements UserDao {
    @Override
    public int addUser(User user) {
        String sql = "insert into usertable (userId,userName,userSex,userPhone,userPassword) values(?,?,?,?,?)";
        Object[] objects = {user.getUserId(), user.getUserName(), user.getUserSex(), user.getUserPhone(), user.getUserPassword()};
        return JDBCUtil.cud(sql, objects);
    }

    @Override
    public int delUser(String userid) {
        String sql = "delete from usertable where userId= ?";
        return JDBCUtil.cud(sql, userid);
    }

    @Override
    public int updateUser(User user) {
        String sql = "update usertable set userName = ? , userSex = ? ,userPhone = ?,userPassword = ? where userId = ?";
        Object[] objects = {user.getUserName(), user.getUserSex(), user.getUserPhone(), user.getUserPassword(), user.getUserId()};
        return JDBCUtil.cud(sql, objects);
    }

    @Override
    public List<User> queryUserList() {
        List<User> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select  userId,userName,userSex,userPhone,userPassword from  usertable;";
        try {
            con = JDBCUtil.getConnection();
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setUserSex(rs.getString(3));
                user.setUserPhone(rs.getString(4));
                user.setUserPassword(rs.getString(5));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.connectClosed(con, st, rs);
        }
        return null;
    }


    @Override
    public User queryUserById(String userId) {
        User user = new User();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select  * from usertable where userId = ?";
        try {
            con = JDBCUtil.getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, userId);
            rs = st.executeQuery();
            while (rs.next()) {
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setUserSex(rs.getString(3));
                user.setUserPhone(rs.getString(4));
                user.setUserPassword(rs.getString(5));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.connectClosed(con, st, rs);
        }
        return null;
    }

    @Override
    public int getCount() {
        int count = 0;
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select  count(userId) from  usertable";
        try {
            con = JDBCUtil.getConnection();
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.connectClosed(con, st, rs);
        }
        return 0;
    }

    @Override
    public List<User> queryByPageIndex(int pageIndex, int pageSize) {
        List<User> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select  userId,userName,userSex,userPhone,userPassword from  usertable limit ?,?";
        try {
            con = JDBCUtil.getConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, (pageIndex - 1) * pageSize);
            st.setInt(2, pageSize);
            rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setUserSex(rs.getString(3));
                user.setUserPhone(rs.getString(4));
                user.setUserPassword(rs.getString(5));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.connectClosed(con, st, rs);
        }
        return null;
    }
}

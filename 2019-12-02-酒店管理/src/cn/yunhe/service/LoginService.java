package cn.yunhe.service;

import cn.yunhe.beans.User;
import cn.yunhe.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 此类用于验证登陆和注册
 *
 * @author Administrator
 */
public class LoginService {
    /**
     * 登陆验证手机和密码
     *
     * @param userPhone
     * @param userPassword
     * @return
     */
    public User login(String userPhone, String userPassword) {
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM usertable WHERE userPhone = ? AND  userPassword = ? ";
        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, userPhone);
            ps.setString(2, userPassword);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setUserSex(rs.getString(3));
                user.setUserPhone(rs.getString(4));
                user.setUserPassword(rs.getString(5));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.connectClosed(conn, ps, rs);
        }
        return null;
    }

    /**
     * 注册账号
     *
     * @param userId
     * @param userName
     * @param userSex
     * @param userPhone
     * @param userPassword
     * @return
     */
    public User register(int userId, String userName, String userSex, String userPhone, String userPassword) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO usertable VALUES(?,?,?,?,?,0,0)";
        User user = new User(userId, userName, userPhone, userSex, userPassword);
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, userName);
            ps.setString(3, userSex);
            ps.setString(4, userPhone);
            ps.setString(5, userPassword);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.connectClosed(conn, ps, null);
        }
        return user;
    }
}

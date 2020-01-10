package cn.yunhe.service;

import cn.yunhe.beans.User;
import cn.yunhe.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserService {
    /**
     * 返回一个包含Vipuser的list
     *
     * @return list
     */
    public List<User> getVipUser() {
        String vipUserSql = " Select * from usertable WHERE userDel != 1 and userVip = 1 ";
        List<User> vipUser = getAllUser(vipUserSql);
        return vipUser;
    }

    /**
     * 显示vipUser
     */
    public void showVipUser() {
        List<User> list = getVipUser();
        for (User u : list
                ) {
            System.out.println(u);
        }
    }

    /**
     * 获取所有的用户
     *
     * @param sql
     * @return
     */
    public List<User> getAllUser(String sql) {

        List<User> list = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setUserPhone(rs.getString(4));
                user.setUserSex(rs.getString(3));
                user.setUserPassword(rs.getString(5));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.connectClosed(conn, st, rs);
        }
        return list;
    }

    /**
     * 显示所有用户
     */
    public void showUser() {
        String allUserSql = " Select * from usertable WHERE userDel != 1 ";
        List<User> list = getAllUser(allUserSql);
        Iterator<User> it = list.iterator();
        for (User u : list
                ) {
            System.out.println(u);
        }
    }

    /**
     * 传入一个user对象
     * 对数据库中用户属性进行修改
     *
     * @param num
     * @param user
     * @param object
     * @return
     */
    public int updateUser(int num, User user, Object object) {
        String column = null;
        switch (num) {
            case 1:
                column = "userId";
                break;
            case 2:
                column = "userName";
                break;
            case 3:
                column = "userSex";
                break;
            case 4:
                column = "userPhone";
                break;
            case 5:
                column = "userDel";
                break;
            case 6:
                column = "userVip";
                break;
            default:
                break;

        }
        String sql = "update usertable set " + column + " =  ?  where userId =  ? and userDel = 0";

        return JDBCUtil.cud(sql, object, user.getUserId());
    }


}

package cn.yunhe.utils;

import cn.yunhe.beans.User;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    /*
     * 定义数据库的路径，以及登录数据库的用户名和密码。
     */
  /*
    private static final String URL = "jdbc:mysql://localhost:3306/hoteldatabase?useUnicode=true&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("驱动注册失败");
        }
    }


    */
    /*
     * 获取连接数据库对象
     *
     * @return connection
     *//*
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("连接失败");
        }
        return connection;
    }
*/
    /*
     *  从Durid缓存池获取连接对象
     */
    public static Connection getConnection() {
        Properties pro = new Properties();

        Connection conn = null;
        try {
            pro.load(new FileInputStream("D:\\IdeaSpace\\2019-12-17-Tomcat\\src\\druid.properties"));
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 关闭连接
     *
     * @param connection 连接对象
     * @param statement
     * @param resultSet  set集合
     */
    public static void connectClosed(Connection connection, Statement statement,
                                     ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static User quire(String sql, Object... objects) {
        User user = new User();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                //把object放入sql语句的适配符中
                st.setObject(i + 1, objects[i]);
            }
            rs = st.executeQuery();
            while (rs.next()) {
                /* 获取行中每一列的数据 */
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setUserPhone(rs.getString(4));
                user.setUserPassWord(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectClosed(con, st, rs);
        return user;
    }

}


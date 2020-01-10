package cn.yunhe.utils;

import org.apache.log4j.Logger;

import java.sql.*;

public class JDBCutil2 {
    /**
     * 定义数据库的路径，以及登录数据库的用户名和密码。
     */
    private static final String URL = "jdbc:mysql://localhost:3306/hoteldatabase?useUnicode=true&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            getLog("驱动注册失败");
        }
    }

    // 注册驱动

    public static void getLog(Object massage) {
        Logger loger = Logger.getLogger(JDBCUtil.class.getName());
        loger.debug(massage);
    }

    /**
     * 获取连接数据库对象
     *
     * @return connection
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            getLog("连接失败");
        }
        return connection;
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

}

package cn.yunhe.util;


import java.sql.*;



public class JDBCUtil {
    /*
     * 定义数据库的路径，以及登录数据库的用户名和密码。
     */

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



    /*
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
            System.out.println("连接失败");
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

    /**
     * 数据库的增删改操作
     * @param sql
     * @param objects
     * @return
     */
    public static int cud(String sql, Object... objects) {
        Connection connection = getConnection();
        PreparedStatement prepareStatement = null;
        int result = 0;
        try {
            prepareStatement = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                prepareStatement.setObject(i + 1, objects[i]);
            }
            result = prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectClosed(connection, prepareStatement, null);
        return result;
    }
}




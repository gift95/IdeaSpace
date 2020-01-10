package cn.yunhe.util;

import java.sql.*;

public class JDBCutil {
    /**
     * 定义数据库位置
     */
    private static final String URL = "jdbc:mysql://localhost:3306/dataemp?useUnicode=true&characterEncoding=utf8";
    /**
     * 定义常量数据库用户名
     */

    private static final String USER = "root";
    /**
     * 定义常量数据库密码
     */
    private static final String PASSWORD = "0000";

    /***
     *注册驱动
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回一个连接对象
     *
     * @return con
     */
    private static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 定义一个关闭方法
     */
    private static void close(Statement statement, Connection connection, ResultSet rs) {
        if (rs != null) {
            //如果rs不为空 那么就关闭数据连接
            try {
                rs.close();
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
     * 传入一个sql语句通过sql语句对数据库进行操作
     *
     * @param sql
     * @return
     */
    public static int cud(String sql) {
        int num = 0;
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            num = st.executeUpdate(sql);
            close(st, con, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public static int cud1(String sql, Object... objects) {
        int num = 0;
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = getConnection();
            st = con.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                st.setObject(i, objects[i]);
                //把object放入sql语句的适配符中
            }
            num = st.executeUpdate();
            close(st, con, null);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(st, con, null);
        }
        return num;
    }

    public static void quirey(String sql) {
        int num = 0;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                   /* 获取行中每一列的数据 */
                int empNo = rs.getInt(1);
                String empName = rs.getString(2);
                String empPhone = rs.getString(3);
                String empAddress = rs.getString(4);
                Date empAge = rs.getDate(5);
                System.out.println(empAddress + "\t" + empName + "\t" + empAge + "\t" + empNo + "\t" + empPhone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(st, con, rs);
    }
}

package cn.yunhe.util;

import java.sql.*;

public class CURD {
    /**
     * 定义数据库位置
     */
    private static final String URL = "jdbc:mysql://localhost:3306/dataemp?useUnicode=true&characterEncoding=utf8";
    /**
     * 定义常量数据库用户名
     */

    private static final String USER = "root";
    /**
    *定义常量数据库密码
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
     * @return
     */
    protected static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 增删改通用方法
     * @param sql
     * @return
     */
    private static int cud(String sql) {
        int num = 0;
        try {
            Connection coon = getConnection();
            Statement ps = coon.createStatement();
            num = ps.executeUpdate(sql);
            ps.close();
            coon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int num = cud("Delete from emp where empno = '1004'");
        if (num == 1) {
            System.out.println("删除成功");
        }
    }
}

package cn.yunhe.jdbcdemo;

import cn.yunhe.util.CURD;

import java.sql.*;

public class Jdbcdemo {
    private static final String URL = "jdbc:mysql://localhost:3306/dataemp?useUnicode=true&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //addmethod();
        //repaire();
       delect("1001");
    }

    public static Connection login() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection coon = DriverManager.getConnection(URL, USER, PASSWORD);
        return coon;
    }

    public static void addmethod() throws ClassNotFoundException, SQLException {

        Connection coon = login();
        String sql = "INSERT INTO emp VALUES('1021','校长','文员',1006,'1998-11-25',185200,5000,20);";
        Statement statement = coon.createStatement();
        int num = statement.executeUpdate(sql);
        System.out.println("结果添加" + num);
        statement.close();
        coon.close();
    }

    public static void repaire() throws ClassNotFoundException, SQLException {
        Connection coon = login();
        String sql = "UPDATE  emp SET  comm=? WHERE empno = ?";
        PreparedStatement ps = coon.prepareStatement(sql);
        ps.setDouble(1, 10000.00);
        ps.setString(2, "1020");
        int num = ps.executeUpdate();

        System.out.println("结果添加" + num);
        ps.close();
        coon.close();
    }

    public static void repaire2() throws ClassNotFoundException, SQLException {
        Connection coon = login();
        String sql = "UPDATE  emp SET  job = '清洁工' WHERE empno = 1020";
        Statement statement = coon.createStatement();
        int num = statement.executeUpdate(sql);
        System.out.println("结果添加" + num);
        statement.close();
        coon.close();
    }
    public static void delect1() throws SQLException, ClassNotFoundException {
        Connection coon = login();
        String sql = "DELETE from emp where empno = 1020";
        Statement st = coon.createStatement();
        int num =  st.executeUpdate(sql);
        System.out.println("结果添加" + num);
        st.close();
        coon.close();
    }
    public static void delect(String nume) throws SQLException, ClassNotFoundException {
        Connection coon = login();
        String sql = "DELETE from emp where empno = ?";
        PreparedStatement st = coon.prepareStatement(sql);
        st.setString(1,nume);
        int num =  st.executeUpdate();
        System.out.println("结果添加" + num);
        st.close();
        coon.close();
    }
    public static void quiery() throws SQLException, ClassNotFoundException {
        Connection coon = login();
        String sql = "SELECT * from emp ";
       Statement st = coon.createStatement();
         ResultSet rs =  st.executeQuery(sql);


        while(rs.next()){

            //获取行中每一列的数据
            int empNo = rs.getInt(1);
            String empName = rs.getString(2);
            String empPhone = rs.getString(3);
            String empAddress = rs.getString(4);
            int empAge = rs.getInt(5);
            System.out.println(empAddress + empName + empAge+empNo);
        }

        rs.close();
        st.close();
        coon.close();
    }
}

package cn.yunhe;

import org.junit.Test;

import java.sql.*;
import java.util.Random;

public class OracleTest {
    @Test
    public void test() throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("oracle.jdbc.OracleDriver");
        //获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
        String sql = "insert INTO t_user values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        String uname = "";
        int age = 1;
        String[] city = {"郑州", "新乡", "漯河", "安阳", "驻马店", "周口"};
        String cityName = "";
        for (int i = 0; i < 10000; i++) {
            uname = "user" + i;
            age = new Random().nextInt(100);
            cityName = city[new Random().nextInt(5)];
            ps.setString(1, uname);
            ps.setString(2, cityName);
            ps.setInt(3, age);
            ps.executeUpdate();
        }
        ps.close();
        connection.close();

    }
}

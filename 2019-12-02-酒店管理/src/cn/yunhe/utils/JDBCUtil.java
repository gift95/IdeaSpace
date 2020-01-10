package cn.yunhe.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.log4j.Logger;


import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class JDBCUtil {
    /**
     * 从连接缓冲池获取Connection对象
     * C3P0缓存池
     **/
    /*
    static {

        try {
            DataSource ds = new  ComboPooledDataSource();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     */

     /*
     *  从Durid缓存池获取连接对象
     */
    public static Connection getConnection() {
        Properties pro = new Properties();

        Connection conn = null;
        try {
            pro.load(JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
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

    public static void getLog(Object massage) {
        Logger loger = Logger.getLogger(JDBCUtil.class.getName());
        loger.debug(massage);
    }

    /**
     * 回收连接
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
     * 增删改通用操作
     *
     * @param sql
     * @return 返回一个结果 显示修改是否成功
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
            getLog("修改失败");
        }
        connectClosed(connection, prepareStatement, null);
        return result;
    }
}

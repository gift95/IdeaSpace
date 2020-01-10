package cn.yunhe.test;

import cn.yunhe.beans.Order;
import cn.yunhe.beans.User;
import cn.yunhe.beans.UserConstom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrserTest {
    @Test
    public void queryOrder() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        User user = session.selectOne("queryUserById", 1);
        System.out.println(user);
        List<Order> orderList = session.selectList("queryOrderByUser", user);
        UserConstom us = new UserConstom();
        us.setUser(user);
        us.setOrderList(orderList);
        System.out.println(us);
        session.close();
        is.close();

    }
}

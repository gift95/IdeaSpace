package cn.yunhe.services;

import cn.yunhe.beans.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class UserServices {
    private FileReader fr = null;
    private SqlSession session = null;

    public SqlSession getSqlSession() throws FileNotFoundException {
        fr = new FileReader("src/SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(fr);
        return sqlSessionFactory.openSession();
    }

    public void close(SqlSession session, FileReader fr) throws IOException {
        session.close();
        fr.close();
    }

    @Test
    public void queryUser() throws IOException {
        session = getSqlSession();
        List<User> empList = session.selectList("service.queryUser");
        System.out.println(empList);
        close(session, fr);
    }

    @Test
    public void queryUserById() throws IOException {
        session = getSqlSession();
        User user = session.selectOne("service.queryUserById", 2);
        System.out.println(user);
        close(session, fr);
    }

    @Test
    public void queryUserLike() throws IOException {
        session = getSqlSession();
        List<User> empList = session.selectList("service.queryUserLike", "x");
        System.out.println(empList);
        close(session, fr);
    }

    @Test
    public void addUser() throws IOException {
        session = getSqlSession();
        User user = new User(4, "小王", "男", "159", "123", "0", "0");
        int num = session.insert("service.addUser", user);
        session.commit();
        System.out.println(num);
        close(session, fr);
    }

    @Test
    public void delUser() throws IOException {
        session = getSqlSession();
        int num = session.delete("service.delUser", 4);
        session.commit();
        System.out.println(num);
        close(session, fr);
    }

    @Test
    public void updateUser() throws IOException {
        session = getSqlSession();
        User user = new User();
        user.setUserId(111);
        user.setUserPhone("123456");
        int num = session.update("service.updateUser", user);
        session.commit();
        System.out.println(num);
        close(session, fr);
    }
}
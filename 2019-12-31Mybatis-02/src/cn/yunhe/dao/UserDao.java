package cn.yunhe.dao;

import cn.yunhe.beans.User;

import java.util.List;

public interface UserDao {
    int addUser(User user);

    int delUser(int userNo);

    int updateUser(User user);

    /**
     * 查询所有的用户信息
     *
     * @return
     */
    List<User> queryUser();

    /**
     * 根据用户id查询用户信息
     *
     * @param userNo
     * @return
     */
    User queryUserById(int userNo);

    List<User> queryUserLike(String name);
}

package cn.yunhe.dao;

import cn.yunhe.beans.User;

import java.util.List;

public interface UserDao {
    /**
     * 增加用户
     *
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户
     *
     * @param userid
     * @return
     */
    int delUser(String userid);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> queryUserList();

    /**
     * 根据用户id查询信息
     *
     * @param userId
     * @return
     */
    User queryUserById(String userId);

    /**
     * 获取总条数
     *
     * @return
     */
    int getCount();

    /**
     * 根据页码查询
     *
     * @param pageIndex
     * @return
     */
    List<User> queryByPageIndex(int pageIndex, int pageSize);
}

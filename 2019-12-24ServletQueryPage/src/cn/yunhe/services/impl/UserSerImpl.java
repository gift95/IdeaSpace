package cn.yunhe.services.impl;

import cn.yunhe.beans.User;
import cn.yunhe.dao.UserDao;
import cn.yunhe.dao.impl.UserImpl;
import cn.yunhe.services.Userservice;

import java.util.List;

public class UserSerImpl implements Userservice {
    private UserDao userimpl = new UserImpl();

    @Override
    public int addUser(User user) {
        return userimpl.addUser(user);
    }

    @Override
    public int delUser(String userid) {
        return userimpl.delUser(userid);
    }

    @Override
    public int updateUser(User user) {
        return userimpl.updateUser(user);
    }

    @Override
    public List<User> queryUserList() {
        return userimpl.queryUserList();
    }

    @Override
    public User queryUserById(String userId) {
        return userimpl.queryUserById(userId);
    }
}


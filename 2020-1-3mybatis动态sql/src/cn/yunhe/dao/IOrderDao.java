package cn.yunhe.dao;

import cn.yunhe.beans.Order;
import cn.yunhe.beans.User;

import java.util.List;

public interface IOrderDao {
    /**
     * 返回所有订单
     *
     * @return
     */
    List<Order> queryAllOrder();

    /**
     * 根据用户查询其订单
     *
     * @param user
     * @return
     */
    List<Order> queryOrderByUser(User user);


}

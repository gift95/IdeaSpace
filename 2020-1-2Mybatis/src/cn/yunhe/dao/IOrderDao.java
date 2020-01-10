package cn.yunhe.dao;

import cn.yunhe.beans.Order;

import java.util.List;

public interface IOrderDao {
    /**
     * 返回所有订单
     *
     * @return
     */
    List<Order> queryAllOrder();

}

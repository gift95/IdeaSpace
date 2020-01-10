package cn.yunhe.beans;

import java.util.List;

/**
 * @author Administrator
 */
public class UserConstom {
    private User user;
    private List<Order> orderList;

    public UserConstom() {
    }

    public UserConstom(User user, List<Order> orderList) {
        this.user = user;
        this.orderList = orderList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "UserConstom{" +
                "user=" + user +
                ", orderList=" + orderList +
                '}';
    }
}

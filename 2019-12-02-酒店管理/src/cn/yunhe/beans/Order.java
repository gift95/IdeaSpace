package cn.yunhe.beans;

import java.util.Arrays;
import java.util.Date;

/**
 * 订单类
 *
 * @author Administrator
 */
public class Order {
    /*    orderId  订单id
    orderCreateTime  订单创建时间
       orderEndTime  订单结束时间
       userId int  用户id
       roomId int 房间id
    */
    private int orderId;
    private int userId;
    private String[] roomId;
    private Date orderCreateTime;
    private Date orderEndTime;

    public Order() {
    }

    public Order(int orderId, int userId, String[] roomId, Date orderCreateTime, Date orderEndTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.roomId = roomId;
        this.orderCreateTime = orderCreateTime;
        this.orderEndTime = orderEndTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String[] getRoomId() {
        return roomId;
    }

    public void setRoomId(String[] roomId) {
        this.roomId = roomId;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Date orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", roomId=" + Arrays.toString(roomId) +
                ", orderCreateTime=" + orderCreateTime.toString() +
                ", orderEndTime=" + orderEndTime.toString() +
                '}';
    }
}

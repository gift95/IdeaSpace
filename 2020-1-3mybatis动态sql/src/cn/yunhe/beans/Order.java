package cn.yunhe.beans;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private int orderId;
    private Date orderCreatTime;
    private Date orderEndTime;
    private int userId;
    private String roomId;

    public Order() {
    }

    public Order(int orderId, Date orderCreatTime, Date orderEndTime, int userId, String roomId) {
        this.orderId = orderId;
        this.orderCreatTime = orderCreatTime;
        this.orderEndTime = orderEndTime;
        this.userId = userId;
        this.roomId = roomId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderCreatTime() {
        return orderCreatTime;
    }

    public void setOrderCreatTime(Date orderCreatTime) {
        this.orderCreatTime = orderCreatTime;
    }

    public Date getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Date orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderCreatTime=" + orderCreatTime +
                ", orderEndTime=" + orderEndTime +
                ", userId=" + userId +
                ", roomId='" + roomId + '\'' +
                '}';
    }
}

package cn.yunhe.beans;

/**
 * ����
 */
public class Order {

    private int orderId;

    private String address;

    public Order() {
    }

    public Order(int orderId, String address) {
        this.orderId = orderId;
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", address=" + address + "]";
    }

}

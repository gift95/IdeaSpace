package cn.yunhe.beans;

/**
 * 订单实体类
 */
public class Order {

	private int orderId;
	
	private String address;
	
	private String phone;

	public Order(){}
	
	public Order(int orderId, String address, String phone) {
		super();
		this.orderId = orderId;
		this.address = address;
		this.phone = phone;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}

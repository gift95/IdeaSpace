package cn.yunhe.beans;

/**
 * 用户实体类
 */
public class User {

	private int userId;
	
	private String userName;
	
	private int type;
	
	public User(){}

	public User(int userId, String userName, int type) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.type = type;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}

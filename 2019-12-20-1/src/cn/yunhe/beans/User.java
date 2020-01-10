package cn.yunhe.beans;

/**
 * 用户实体类
 *
 * @author Administrator
 */
public class User {
    private int userId;
    private String userName;
    private String userSex;
    private String userPhone;

    private String userPassword;

    public User() {
    }

    public User(int userId, String userName, String userPhone, String userSex, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userSex = userSex;
        this.userPassword = userPassword;
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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "用户Id=" + userId +
                ", 用户名='" + userName + '\'' +
                ", 用户手机='" + userPhone + '\'' +
                ", 用户性别='" + userSex + '\''
                + "用户密码 = " + userPassword +
                '}';
    }


}

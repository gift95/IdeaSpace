package cn.yunhe.beans;

public class User {
    private int userId;
    private String userName;
    private String userSex;
    private String userPhone;
    private String userPassword;
    private String userVip;
    private String userDel;

    public User() {
    }

    public User(int userId, String userName, String userSex, String userPhone, String userPassword, String userVip, String userDel) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userVip = userVip;
        this.userDel = userDel;
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

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserVip() {
        return userVip;
    }

    public void setUserVip(String userVip) {
        this.userVip = userVip;
    }

    public String getUserDel() {
        return userDel;
    }

    public void setUserDel(String userDel) {
        this.userDel = userDel;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userVip='" + userVip + '\'' +
                ", userDel='" + userDel + '\'' +
                '}';
    }
}

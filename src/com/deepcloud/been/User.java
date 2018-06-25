package com.deepcloud.been;

/**
 * @ Author     ：xzp.
 * @ Date       ：Created in 上午9:48 2018/6/25
 * @ Description：用户类的封装类，通过isManager来判断是否是管理员
 */
public class User {

    private String userName;
    private String userPassword;
    private int isManager;

    public User() {

    }

    public User(String userName, String userPassword, int isManager) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.isManager = isManager;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getIsManager() {
        return isManager;
    }

    public void setIsManager(int isManager) {
        this.isManager = isManager;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", isManager=" + isManager +
                '}';
    }
}

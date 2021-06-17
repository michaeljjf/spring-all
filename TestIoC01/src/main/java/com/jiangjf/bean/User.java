package com.jiangjf.bean;

public class User {
    private Integer userid;
    private String username;
    private String password;

    public User() {
        System.out.println("User无参构建方法");
    }

    public User(Integer userid, String username, String password) {
        System.out.println("User全参构建方法");
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    public Integer getUserid() {
        System.out.println("User getUserid");
        return userid;
    }

    public void setUserid(Integer userid) {
        System.out.println("User setUserid");
        this.userid = userid;
    }

    public String getUsername() {
        System.out.println("User getUsername");
        return username;
    }

    public void setUsername(String username) {
        System.out.println("User setUsername");
        this.username = username;
    }

    public String getPassword() {
        System.out.println("User getPassword");
        return password;
    }

    public void setPassword(String password) {
        System.out.println("User setPassword");
        this.password = password;
    }

    @Override
    public String toString() {
        System.out.println("User toString");
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

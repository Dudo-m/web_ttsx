package com.edu.entity;

import java.io.Serializable;

public class User implements Serializable {
    private int user_id;
    private String user_account;
    private String user_password;
    private String user_email;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public User(int user_id, String user_account, String user_password, String user_email) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_password = user_password;
        this.user_email = user_email;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_account='" + user_account + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_email='" + user_email + '\'' +
                '}';
    }
}

package com.example.demo.pojo;

import java.io.Serializable;

public class Password implements Serializable {
    private Integer lockId;

    private String password;

    private static final long serialVersionUID = 1L;

    public Integer getLockId() {
        return lockId;
    }

    public void setLockId(Integer lockId) {
        this.lockId = lockId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
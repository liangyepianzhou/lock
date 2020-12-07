package com.example.demo.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class Users implements Serializable {
    private Integer lockId;

    private String username;

    private String password;

    private Integer id;

    private String code;

    private static final long serialVersionUID = 1L;

    public Integer getLockId() {
        return lockId;
    }

    public void setLockId(Integer lockId) {
        this.lockId = lockId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
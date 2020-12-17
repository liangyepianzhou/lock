package com.example.demo.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class Users implements Serializable {
    private String iphonecall;

    private String number;

    private String name;

    private Integer lockId;

    private Integer temppass;

    private static final long serialVersionUID = 1L;

    public String getIphonecall() {
        return iphonecall;
    }

    public void setIphonecall(String iphonecall) {
        this.iphonecall = iphonecall;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLockId() {
        return lockId;
    }

    public void setLockId(Integer lockId) {
        this.lockId = lockId;
    }

    public Integer getTemppass() {
        return temppass;
    }

    public void setTemppass(Integer temppass) {
        this.temppass = temppass;
    }
}
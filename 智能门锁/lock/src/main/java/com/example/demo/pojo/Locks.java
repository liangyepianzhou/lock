package com.example.demo.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class Locks implements Serializable {
    private String lockId;

    private String password;

    private String ip;

    private Integer mumber;

    private Integer advice;

    private static final long serialVersionUID = 1L;

    public String getLockId() {
        return lockId;
    }

    public void setLockId(String lockId) {
        this.lockId = lockId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getMumber() {
        return mumber;
    }

    public void setMumber(Integer mumber) {
        this.mumber = mumber;
    }

    public Integer getAdvice() {
        return advice;
    }

    public void setAdvice(Integer advice) {
        this.advice = advice;
    }

    @Override
    public String toString() {
        return "Locks{" +
                "lockId='" + lockId + '\'' +
                ", password='" + password + '\'' +
                ", ip='" + ip + '\'' +
                ", mumber=" + mumber +
                ", advice=" + advice +
                '}';
    }
}
package com.example.demo.pojo;

import java.io.Serializable;
import java.util.Date;

public class Temppasw implements Serializable {
    private Integer ids;

    private Integer lockId;

    private Integer id;

    private String password;

    private Date time;

    private static final long serialVersionUID = 1L;

    public Integer getIds() {
        return ids;
    }

    public void setIds(Integer ids) {
        this.ids = ids;
    }

    public Integer getLockId() {
        return lockId;
    }

    public void setLockId(Integer lockId) {
        this.lockId = lockId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
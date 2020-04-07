package com.fy.entity;

import java.util.Date;

public class Repair {
    private int id;
    private int user_id;
    private String address;
    private String fault;
    private String tel;
    private String description;
    private Date repair_time;
    private int state;

    public Repair(int id, int user_id, String address, String fault, String tel, String description, Date repair_time, int state) {
        this.id = id;
        this.user_id = user_id;
        this.address = address;
        this.fault = fault;
        this.tel = tel;
        this.description = description;
        this.repair_time = repair_time;
        this.state = state;
    }

    public Repair() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFault() {
        return fault;
    }

    public void setFault(String fault) {
        this.fault = fault;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRepair_time() {
        return repair_time;
    }

    public void setRepair_time(Date repair_time) {
        this.repair_time = repair_time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

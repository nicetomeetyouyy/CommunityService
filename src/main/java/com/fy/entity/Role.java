package com.fy.entity;

import java.util.Date;

public class Role {

    private int role_id;
    private String role_name;
    private Date create_time;
    private String description;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Role(int role_id, String role_name, Date create_time, String description) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.create_time = create_time;
        this.description = description;
    }

    public Role() {
    }
}

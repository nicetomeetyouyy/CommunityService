package com.fy.entity;

import java.util.Date;

public class RentList {
    private int id;
    private String location;
    private String money;
    private String types;
    private String area;
    private String image;
    private Date push_time;
    private String tel;
    private String froms;

    public RentList(int id, String location, String money, String types, String area, String image, Date push_time, String tel, String froms, String title) {
        this.id = id;
        this.location = location;
        this.money = money;
        this.types = types;
        this.area = area;
        this.image = image;
        this.push_time = push_time;
        this.tel = tel;
        this.froms = froms;
        this.title = title;
    }

    private String title;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getPush_time() {
        return push_time;
    }

    public void setPush_time(Date push_time) {
        this.push_time = push_time;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public RentList() {
    }

    public String getFroms() {
        return froms;
    }

    public void setFroms(String froms) {
        this.froms = froms;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

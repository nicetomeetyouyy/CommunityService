package com.fy.entity;

import java.util.Date;

public class Sell {
    private int id;
    private String title;
    private String description;
    private String money;
    private String tel;
    private String froms;
    private String image;
    private Date push_time;

    public Sell() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFroms() {
        return froms;
    }

    public void setFroms(String froms) {
        this.froms = froms;
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

    public Sell(int id, String title, String description, String money, String tel, String froms, String image, Date push_time) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.money = money;
        this.tel = tel;
        this.froms = froms;
        this.image = image;
        this.push_time = push_time;
    }
}

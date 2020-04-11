package com.fy.entity;

import java.util.Date;

public class OwnerBill {
    private int id;
    private Long owner_id;
    private String address;
    private String area;
    private String cost;
    private String other;
    private String other_cost;
    private String total;
    private int state;
    private Date create_time;

    public OwnerBill(int id, Long owner_id, String address, String area, String cost, String other, String other_cost, String total, int state, Date create_time) {
        this.id = id;
        this.owner_id = owner_id;
        this.address = address;
        this.area = area;
        this.cost = cost;
        this.other = other;
        this.other_cost = other_cost;
        this.total = total;
        this.state = state;
        this.create_time = create_time;
    }

    public OwnerBill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getOther_cost() {
        return other_cost;
    }

    public void setOther_cost(String other_cost) {
        this.other_cost = other_cost;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}

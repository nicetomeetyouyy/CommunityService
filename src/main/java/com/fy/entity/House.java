package com.fy.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Date;

@NodeEntity(label = "house")
public class House {
    @Id@GeneratedValue
    private Long id;
    private String address;
    private int area;
    private String type;
    private Date register_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Date register_time) {
        this.register_time = register_time;
    }

    public House(Long id, String address, int area, String type, Date register_time) {
        this.id = id;
        this.address = address;
        this.area = area;
        this.type = type;
        this.register_time = register_time;
    }

    public House() {
    }
}
package com.fy.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label = "park")
public class Park {
    @Id@GeneratedValue
    private Long id;
    private String location;
    private String state;
    private String sale_time;
    private String expired_time;

    public Park() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSale_time() {
        return sale_time;
    }

    public void setSale_time(String sale_time) {
        this.sale_time = sale_time;
    }

    public String getExpired_time() {
        return expired_time;
    }

    public void setExpired_time(String expired_time) {
        this.expired_time = expired_time;
    }

    public Park(Long id, String location, String state, String sale_time, String expired_time) {
        this.id = id;
        this.location = location;
        this.state = state;
        this.sale_time = sale_time;
        this.expired_time = expired_time;
    }
}

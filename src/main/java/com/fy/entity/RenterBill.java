package com.fy.entity;

import java.util.Date;

public class RenterBill {
    private int id;
    private int renter_id;
    private String address;
    private int room_charge;
    private int use_power;
    private int use_water;
    private int use_gas;
    private int power_cost;
    private int water_cost;
    private int gas_cost;
    private int total_cost;
    private int state;
    private int owner_id;
    private Date create_time;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRenter_id() {
        return renter_id;
    }

    public void setRenter_id(int renter_id) {
        this.renter_id = renter_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoom_charge() {
        return room_charge;
    }

    public void setRoom_charge(int room_charge) {
        this.room_charge = room_charge;
    }

    public int getUse_power() {
        return use_power;
    }

    public void setUse_power(int use_power) {
        this.use_power = use_power;
    }

    public int getUse_water() {
        return use_water;
    }

    public void setUse_water(int use_water) {
        this.use_water = use_water;
    }

    public int getUse_gas() {
        return use_gas;
    }

    public void setUse_gas(int use_gas) {
        this.use_gas = use_gas;
    }

    public int getPower_cost() {
        return power_cost;
    }

    public void setPower_cost(int power_cost) {
        this.power_cost = power_cost;
    }

    public int getWater_cost() {
        return water_cost;
    }

    public void setWater_cost(int water_cost) {
        this.water_cost = water_cost;
    }

    public int getGas_cost() {
        return gas_cost;
    }

    public void setGas_cost(int gas_cost) {
        this.gas_cost = gas_cost;
    }

    public int getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(int total_cost) {
        this.total_cost = total_cost;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public RenterBill() {
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public RenterBill(int id, int renter_id, String address, int room_charge, int use_power, int use_water, int use_gas, int power_cost, int water_cost, int gas_cost, int total_cost, int state, int owner_id, Date create_time) {
        this.id = id;
        this.renter_id = renter_id;
        this.address = address;
        this.room_charge = room_charge;
        this.use_power = use_power;
        this.use_water = use_water;
        this.use_gas = use_gas;
        this.power_cost = power_cost;
        this.water_cost = water_cost;
        this.gas_cost = gas_cost;
        this.total_cost = total_cost;
        this.state = state;
        this.owner_id = owner_id;
        this.create_time = create_time;
    }
}

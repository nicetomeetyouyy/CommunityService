package com.fy.service;

import com.fy.entity.RenterBill;

import java.util.List;

public interface RenterBillService {
    public List<RenterBill> findRenterBillByRenter_id(int renter_id);
    public int getRenter_billNumber();
    public List<RenterBill> getBillNumberByPage(int limit, int offset);
    public void insertRenterBill(RenterBill renterBill);
    public void deleteRenterBill(int id);
    public List<RenterBill> findRenterBillByOwner_id(int owner_id);
    public void updateRenterBill(int state,int id);
}

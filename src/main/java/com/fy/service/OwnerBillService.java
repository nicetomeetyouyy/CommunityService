package com.fy.service;

import com.fy.entity.OwnerBill;

import java.util.List;

public interface OwnerBillService {
    List<OwnerBill> findByOwner(int owner_id);
    int getOwnerBillNumber();
    List<OwnerBill>getOwnerBillByPage(int limit,int offset);
    void insertOwnerBill(OwnerBill ownerBill);
    void deleteOwnerBill(int id);
    void updateState(int state,int id);
}

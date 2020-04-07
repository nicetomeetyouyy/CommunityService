package com.fy.dao;

import com.fy.entity.RenterBill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RenterBillDao {
    public List<RenterBill> findRenterBillByRenter_id(int renter_id);

    public int getRenter_billNumber();

    public List<RenterBill> getBillNumberByPage(int limit, int offset);

    public void insertRenterBill(RenterBill renterBill);

    public void deleteRenterBill(int id);

    public List<RenterBill> findRenterBillByOwner_id(int owner_id);

    public void updateRenterBill(int state,int id);
}

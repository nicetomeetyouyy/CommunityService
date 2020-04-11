package com.fy.dao;

import com.fy.entity.OwnerBill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OwnerBillDao {
    List<OwnerBill> findByOwner(int owner_id);
    int getOwnerBillNumber();
    List<OwnerBill>getOwnerBillByPage(int limit,int offset);
    void insertOwnerBill(OwnerBill ownerBill);
    void deleteOwnerBill(int id);
    void updateState(int state,int id);
}

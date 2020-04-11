package com.fy.service.impl;

import com.fy.dao.OwnerBillDao;
import com.fy.entity.OwnerBill;
import com.fy.service.OwnerBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OwnerBillServiceImpl implements OwnerBillService {
    @Autowired
    private OwnerBillDao ownerBillDao;
    @Override
    public List<OwnerBill> findByOwner(int owner_id) {
        return ownerBillDao.findByOwner(owner_id);
    }

    @Override
    public int getOwnerBillNumber() {
        return ownerBillDao.getOwnerBillNumber();
    }

    @Override
    public List<OwnerBill> getOwnerBillByPage(int limit, int offset) {
        return ownerBillDao.getOwnerBillByPage(limit,offset);
    }

    @Override
    public void insertOwnerBill(OwnerBill ownerBill) {
        ownerBillDao.insertOwnerBill(ownerBill);
    }

    @Override
    public void deleteOwnerBill(int id) {
         ownerBillDao.deleteOwnerBill(id);
    }

    @Override
    public void updateState(int state, int id) {
        ownerBillDao.updateState(state,id);
    }
}

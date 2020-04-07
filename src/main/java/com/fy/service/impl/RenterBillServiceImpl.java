package com.fy.service.impl;

import com.fy.dao.RenterBillDao;
import com.fy.entity.RenterBill;
import com.fy.service.RenterBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RenterBillServiceImpl implements RenterBillService {
    @Autowired
    private RenterBillDao renterBillDao;
    @Override
    public List<RenterBill> findRenterBillByRenter_id(int renter_id) {
        return renterBillDao.findRenterBillByRenter_id(renter_id);
    }

    @Override
    public int getRenter_billNumber() {
        return renterBillDao.getRenter_billNumber();
    }

    @Override
    public List<RenterBill> getBillNumberByPage(int limit, int offset) {
        return renterBillDao.getBillNumberByPage(limit,offset);
    }

    @Override
    public void insertRenterBill(RenterBill renterBill) {
        renterBillDao.insertRenterBill(renterBill);
    }

    @Override
    public void deleteRenterBill(int id) {
        renterBillDao.deleteRenterBill(id);
    }

    @Override
    public List<RenterBill> findRenterBillByOwner_id(int owner_id) {
        return renterBillDao.findRenterBillByOwner_id(owner_id);
    }

    @Override
    public void updateRenterBill(int state, int id) {
        renterBillDao.updateRenterBill(state,id);
    }
}

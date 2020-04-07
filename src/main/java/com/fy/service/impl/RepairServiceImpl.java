package com.fy.service.impl;

import com.fy.dao.RepairDao;
import com.fy.entity.Repair;
import com.fy.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairDao repairDao;
    @Override
    public int getRepairNumber() {
        return repairDao.getRepairNumber();
    }

    @Override
    public List<Repair> findRepairByPage(int limit, int offset) {
        return repairDao.findRepairByPage(limit,offset);
    }

    @Override
    public void insertRepair(Repair repair) {
        repairDao.insertRepair(repair);
    }

    @Override
    public void deleteRepair(int id) {
        repairDao.deleteRepair(id);
    }

    @Override
    public void updateState(int state, int id) {
        repairDao.updateState(state,id);
    }

    @Override
    public List<Repair> findRepairByUserId(int user_id) {
        return repairDao.findRepairByUserId(user_id);
    }

    @Override
    public List<Repair> untreatedRepair() {
        return repairDao.untreatedRepair();
    }

}
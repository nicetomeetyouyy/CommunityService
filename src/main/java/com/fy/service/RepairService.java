package com.fy.service;

import com.fy.entity.Repair;

import java.util.List;

public interface RepairService {
    public int getRepairNumber();
    public List<Repair> findRepairByPage(int limit, int offset);
    public void insertRepair(Repair repair);
    public void deleteRepair(int id);
    public void updateState(int state,int id);
    public List<Repair> findRepairByUserId(int user_id);
    List<Repair> untreatedRepair();
}

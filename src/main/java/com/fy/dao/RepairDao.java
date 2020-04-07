package com.fy.dao;

import com.fy.entity.Repair;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RepairDao {
    public int getRepairNumber();
    public List<Repair> findRepairByPage(int limit, int offset);
    public void insertRepair(Repair repair);
    public void deleteRepair(int id);
    public void updateState(int state,int id);
    public List<Repair> findRepairByUserId(int user_id);
    List<Repair> untreatedRepair();
}

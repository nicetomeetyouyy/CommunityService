package com.fy.dao;

import com.fy.entity.RentList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RentListDao {
    List<RentList> findByUser(String froms);
    int getRentListNumber();
    List<RentList> getRentListByPage(int limit,int offset);
    void insertRentList(RentList rentList);
    void deleteRentList(int id);
}

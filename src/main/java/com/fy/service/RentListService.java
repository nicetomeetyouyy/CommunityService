package com.fy.service;

import com.fy.entity.RentList;

import java.util.List;

public interface RentListService {
    List<RentList> findByUser(String froms);
    int getRentListNumber();
    List<RentList> getRentListByPage(int limit,int offset);
    void insertRentList(RentList rentList);
    void deleteRentList(int id);
}

package com.fy.service;

import com.fy.entity.Sell;

import java.util.List;

public interface SellService {
    List<Sell> findByUser(String froms);
    int getSellNumber();
    List<Sell> getSellByPage(int limit,int offset);
    void insertSell(Sell sell);
    void deleteSell(int id);
}

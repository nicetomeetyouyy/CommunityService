package com.fy.dao;

import com.fy.entity.Sell;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellDao {
    List<Sell> findByUser(String froms);
    int getSellNumber();
    List<Sell> getSellByPage(int limit,int offset);
    void insertSell(Sell sell);
    void deleteSell(int id);
}

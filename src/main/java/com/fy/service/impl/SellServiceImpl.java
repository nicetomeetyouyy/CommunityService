package com.fy.service.impl;

import com.fy.dao.SellDao;
import com.fy.entity.Sell;
import com.fy.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SellServiceImpl implements SellService {
    @Autowired
    private SellDao sellDao;
    @Override
    public List<Sell> findByUser(String froms) {
        return sellDao.findByUser(froms);
    }

    @Override
    public int getSellNumber() {
        return sellDao.getSellNumber();
    }

    @Override
    public List<Sell> getSellByPage(int limit, int offset) {
        return sellDao.getSellByPage(limit,offset);
    }

    @Override
    public void insertSell(Sell sell) {
         sellDao.insertSell(sell);
    }

    @Override
    public void deleteSell(int id) {
       sellDao.deleteSell(id);
    }
}

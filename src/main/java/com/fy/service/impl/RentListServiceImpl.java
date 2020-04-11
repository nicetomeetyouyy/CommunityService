package com.fy.service.impl;

import com.fy.dao.RentListDao;
import com.fy.entity.RentList;
import com.fy.service.RentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentListServiceImpl implements RentListService {
    @Autowired
    private RentListDao rentListDao;
    @Override
    public List<RentList> findByUser(String froms) {
        return rentListDao.findByUser(froms);
    }

    @Override
    public int getRentListNumber() {
        return rentListDao.getRentListNumber();
    }

    @Override
    public List<RentList> getRentListByPage(int limit, int offset) {
        return rentListDao.getRentListByPage(limit,offset);
    }

    @Override
    public void insertRentList(RentList rentList) {
rentListDao.insertRentList(rentList);
    }

    @Override
    public void deleteRentList(int id) {
rentListDao.deleteRentList(id);
    }
}

package com.fy.service.impl;

import com.fy.dao.AdviceDao;
import com.fy.entity.Advice;
import com.fy.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdviceServiceImpl implements AdviceService {
    @Autowired
    private AdviceDao adviceDao;

    @Override
    public int getAdviceNumber() {
        return adviceDao.getAdviceNumber();
    }

    @Override
    public List<Advice> findAdviceByPage(int limit, int offset) {
        return adviceDao.findAdviceByPage(limit,offset);
    }

    @Override
    public void insertAdvice(Advice advice) {
      adviceDao.insertAdvice(advice);
    }

    @Override
    public void deleteAdvice(int id) {
       adviceDao.deleteAdvice(id);
    }

    @Override
    public List<Advice> findByUserId(int user_id) {
        return adviceDao.findByUserId(user_id);
    }

    @Override
    public void updateAdvice(String answer, int id) {
        adviceDao.updateAdvice(answer,id);
    }

    @Override
    public List<Advice> untreatedAdvice() {
        return adviceDao.untreatedAdvice();
    }
}

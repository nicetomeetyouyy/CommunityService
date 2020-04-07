package com.fy.service;

import com.fy.entity.Advice;

import java.util.List;

public interface AdviceService {
    public int getAdviceNumber();
    public List<Advice> findAdviceByPage(int limit, int offset);
    public void insertAdvice(Advice advice);
    public void deleteAdvice(int id);
    public List<Advice> findByUserId(int user_id);
    public void updateAdvice(String answer,int id);
    public List<Advice> untreatedAdvice();
}

package com.fy.dao;

import com.fy.entity.Advice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdviceDao {
    public int getAdviceNumber();
    public List<Advice> findAdviceByPage(int limit,int offset);
    public void insertAdvice(Advice advice);
    public void deleteAdvice(int id);
    public List<Advice> findByUserId(int user_id);
    public void updateAdvice(String answer,int id);
    public List<Advice> untreatedAdvice();
}

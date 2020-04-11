package com.fy.dao;

import com.fy.entity.LoginUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginUserDao {

    public LoginUser queryNameAndPassword(String name, String password);
    public void insertLoginUser(String login_name,String password);
    public void updateLoginTime(int user_id);
    public void deleteLoginUserByUser_id(int user_id);
    public int getUserNumber();
    public List<LoginUser> getUserByPage(int limit, int offset);
    public List<LoginUser> seachUser(String key);
    public void updatePassward(int user_id,String password);
    public LoginUser findByUser_id(int user_id);
}

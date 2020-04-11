package com.fy.service.impl;

import com.fy.dao.LoginUserDao;
import com.fy.entity.LoginUser;
import com.fy.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginUserServiceImpl implements LoginUserService {
    @Autowired
    private LoginUserDao loginUserDao;

    /**
     * 验证账号密码
     * @param
     * @param
     * @return
     */
    @Override
    public LoginUser queryNameAndPassword(String name, String password) {
        return loginUserDao.queryNameAndPassword(name,password);
    }

    /**
     * 注册账号
     * @param login_name
     * @param
     */
    @Override
    public void insertLoginUser(String login_name, String password) {
     loginUserDao.insertLoginUser(login_name,password);
    }

    /**
     * 增加登陆次数
     * @param count
     * @param user_id
     */

    /**
     * 存入登陆时间
     * @param user_id
     */
    @Override
    public void updateLoginTime(int user_id) {
      loginUserDao.updateLoginTime(user_id);
    }

    /**
     * 根据user_id删除用户
     * @param user_id
     */
    @Override
    public void deleteLoginUserByUser_id(int user_id) {
      loginUserDao.deleteLoginUserByUser_id(user_id);
    }

    /**
     * 返回用户总数
     * @return
     */
    @Override
    public int getUserNumber() {
        return loginUserDao.getUserNumber();
    }

    /**
     * 从offset位置开始每次返回limit个数据
     * @param limit
     * @param offset
     * @return
     */
    @Override
    public List<LoginUser> getUserByPage(int limit, int offset) {
        return loginUserDao.getUserByPage(limit,offset);
    }

    @Override
    public List<LoginUser> seachUser(String key) {
        return loginUserDao.seachUser(key);
    }

    @Override
    public void updatePassword(int user_id, String password) {
        loginUserDao.updatePassward(user_id,password);
    }

    @Override
    public LoginUser findByUser_id(int user_id) {
        return loginUserDao.findByUser_id(user_id);
    }
}

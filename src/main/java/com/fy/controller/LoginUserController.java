package com.fy.controller;

import com.fy.entity.LoginUser;
import com.fy.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginUserController {
    @Autowired
    private LoginUserService loginUserService;

    /**
     * 登陆验证
     * @param login_name
     * @param
     * @return
     */
    @RequestMapping("login/action")
    public Map<String, Object> loginAction(String login_name, String password){
        LoginUser loginUser=loginUserService.queryNameAndPassword(login_name,password);
        Map<String,Object> map=new HashMap<>();
        if(loginUser!=null){
            map.put("code","0");
            map.put("msg","登陆成功");
            map.put("user_id",loginUser.getUser_id());
            loginUserService.updateLoginTime(loginUser.getUser_id());
            return map;
        }else{
            map.put("code","-1");
            map.put("msg","登陆成功");
            map.put("user_id",null);
            return map;
        }
    }
   @RequestMapping("login/register")
    public Map<String,Object> loginRegister(String login_name, String passward){
        loginUserService.insertLoginUser(login_name,passward);
        LoginUser loginUser=loginUserService.queryNameAndPassword(login_name,passward);
        Map<String,Object> map=new HashMap<>();
        if(loginUser!=null){
            map.put("code","0");
            map.put("msg","注册成功");
            map.put("user_id",loginUser.getUser_id());
            return map;
        }else{
            map.put("code","-1");
            map.put("msg","注册失败");
            map.put("user_id",null);
            return map;
        }
    }

    @RequestMapping("user/update_password")
    public Map<String,Object> updatePassword(String user_id,String password){

        int id= Integer.valueOf(user_id);
        loginUserService.updatePassword(id,password);
        LoginUser loginUser=loginUserService.findByUser_id(id);
        Map<String,Object> map=new HashMap<>();
        if(loginUser!=null){
            map.put("code","0");
            map.put("msg","修改成功");
            return map;
        }else{
            map.put("code","-1");
            map.put("msg","修改失败");
            return map;
        }
    }
    @RequestMapping("user/my_info")
    public LoginUser findUserById(String user_id){
        int id= Integer.valueOf(user_id);
        LoginUser loginUser=loginUserService.findByUser_id(id);
        if(loginUser!=null){
            return loginUser;
        }else return null;
    }

    @RequestMapping("user/delete")
    public Map<String,Object> deleteUserById(String user_id){
        int id= Integer.valueOf(user_id);
        loginUserService.deleteLoginUserByUser_id(id);
        LoginUser loginUser=loginUserService.findByUser_id(id);
        Map<String,Object> map=new HashMap<>();
        if(loginUser!=null){
            map.put("code","-1");
            map.put("msg","删除失败");
            return map;
        }else{
            map.put("code","0");
            map.put("msg","删除成功");
            return map;
        }
    }
}

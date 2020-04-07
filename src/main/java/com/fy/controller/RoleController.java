package com.fy.controller;

import com.fy.entity.Role;
import com.fy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping("getRole/all")
    public List<Role> findAllRole(){
        List<Role> roles=new ArrayList<>();
        roles= roleService.findRoleAll();
        if(roles!=null){
            return roles;
        }else return null;
    }

    @RequestMapping("role/addRole")
    public Map<String,Object> addRole(String role_name,String description){
        Map<String,Object> map=new HashMap<>();
        try {
            roleService.insertRole(role_name,description);
        }catch (Exception e){

            map.put("code","-1");
            map.put("msg","添加失败");
            return map;
        }
        map.put("code","0");
        map.put("msg","添加成功");
            return map;
    }
    @RequestMapping("role/updateRole")
    public Map<String,Object> updateRole(String role_id, String role_name,String description){
        int id=Integer.valueOf(role_id);
        Map<String,Object> map=new HashMap<>();
        try {
            roleService.updateRole(id, role_name,description);
        }catch (Exception e){
            map.put("code","-1");
            map.put("msg","修改失败");
            return map;
        }
        map.put("code","0");
        map.put("msg","修改成功");
        return map;
    }

    @RequestMapping("role/delete")
    public Map<String,Object> deleteUserById(String role_id){
        int id= Integer.valueOf(role_id);
        roleService.deleteRole(id);
        Map<String,Object> map=new HashMap<>();
        try {
            roleService.deleteRole(id);
        }catch (Exception e){
            map.put("code","-1");
            map.put("msg","删除失败");
            return map;
        }
        map.put("code","0");
        map.put("msg","删除成功");
        return map;
    }
}

package com.fy.dao;

import com.fy.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleDao {

    public Role findRoleById(int role_id);
    public List<Role> findRoleAll();
    public void insertRole(String role_name,String description);
    public void updateRole(int role_id,String role_name,String description);
    public void deleteRole(int role_id);
}

package com.fy.dao;

import com.fy.entity.LoginUser;
import com.fy.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDao {

    Role findRoleById(int role_id);

    List<Role> findRoleAll();

    void insertRole(String role_name, String description);

    void updateRole(int role_id, String role_name, String description);

    void deleteRole(int role_id);

    Role findUserRole(int user_id);

    void insertUserRole(int role_id, int user_id);

    void deleteUserRole(int role_id, int user_id);
}

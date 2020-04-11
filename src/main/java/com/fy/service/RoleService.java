package com.fy.service;

import com.fy.entity.Role;

import java.util.List;

public interface RoleService {
    public Role findRoleById(int role_id);
    public List<Role> findRoleAll();
    public void insertRole(String role_name,String description);
    public void updateRole(int role_id,String role_name,String description);
    public void deleteRole(int role_id);
    Role findUserRole(int user_id);

    void insertUserRole(int role_id, int user_id);

    void deleteUserRole(int role_id, int user_id);
}

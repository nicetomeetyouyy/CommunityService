package com.fy.service.impl;

import com.fy.dao.RoleDao;
import com.fy.entity.Role;
import com.fy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    /**
     * 根据role_id查找ROle
     * @param role_id
     * @return
     */
    @Override
    public Role findRoleById(int role_id) {
        return roleDao.findRoleById(role_id);
    }

    /**
     * 查找所有Role
     * @return
     */
    @Override
    public List<Role> findRoleAll() {
        return roleDao.findRoleAll();
    }

    /**
     * 增加角色
     * @param role_name
     * @param description
     */
    @Override
    public void insertRole(String role_name, String description) {
       roleDao.insertRole(role_name,description);
    }

    /**
     * 修改角色信息
     * @param role_id
     * @param role_name
     * @param description
     */
    @Override
    public void updateRole(int role_id, String role_name, String description) {
       roleDao.updateRole(role_id,role_name,description);
    }

    /**
     * 删除角色
     * @param role_id
     */
    @Override
    public void deleteRole(int role_id) {
       roleDao.deleteRole(role_id);
    }
}

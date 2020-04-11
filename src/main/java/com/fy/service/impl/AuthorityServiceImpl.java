package com.fy.service.impl;

import com.fy.dao.AuthorityDao;
import com.fy.entity.Authority;
import com.fy.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityDao authorityDao;
    @Override
    public List<Authority> findAll() {
        return authorityDao.findAll();
    }

    @Override
    public List<Authority> findRoleAuthority(int role_id) {
        return authorityDao.findRoleAuthority(role_id);
    }

    @Override
    public void insertRoleAuthority(int role_id, int authority_id) {
        authorityDao.insertRoleAuthority(role_id,authority_id);
    }

    @Override
    public void deleteRoleAuthority(int role_id, int authority_id) {
        authorityDao.deleteRoleAuthority(role_id,authority_id);
    }


}

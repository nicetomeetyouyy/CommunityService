package com.fy.service;

import com.fy.entity.Authority;

import java.util.List;

public interface AuthorityService {
    List<Authority> findAll();

    List<Authority> findRoleAuthority(int role_id);

    void insertRoleAuthority(int role_id,int authority_id);

    void deleteRoleAuthority(int role_id,int authority_id);
}

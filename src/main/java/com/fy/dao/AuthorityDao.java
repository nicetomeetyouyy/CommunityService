package com.fy.dao;

import com.fy.entity.Authority;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AuthorityDao {

     List<Authority> findAll();

     List<Authority> findRoleAuthority(int role_id);

     void insertRoleAuthority(int role_id,int authority_id);

     void deleteRoleAuthority(int role_id,int authority_id);
}

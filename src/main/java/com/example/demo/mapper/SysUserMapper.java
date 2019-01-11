package com.example.demo.mapper;

import com.example.demo.model.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);
    SysUser findByUserName(String username);
    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}
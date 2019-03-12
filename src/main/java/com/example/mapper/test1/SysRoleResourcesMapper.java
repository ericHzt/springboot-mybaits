package com.example.mapper.test1;

import com.example.model.SysRoleResources;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleResourcesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleResources record);

    int insertSelective(SysRoleResources record);

    SysRoleResources selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleResources record);

    int updateByPrimaryKey(SysRoleResources record);
}
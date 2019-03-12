package com.example.mapper.test2;

import com.example.model.SysUser;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper2 {

    @Select("select * from sys_user where user_name = #{userName} and pass_word = #{passWord}")
    @Results({
            @Result(property = "userName",  column = "user_name"),
            @Result(property = "passWord", column = "pass_word"),
            @Result(property = "userEnable", column = "user_enable")
    })
    SysUser getByUser(SysUser user);
}

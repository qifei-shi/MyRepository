package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper  {

    //查询全部用户
    User queryUsers(@Param("id")int id);

    //修改用户
    int updateUser(User user);
}

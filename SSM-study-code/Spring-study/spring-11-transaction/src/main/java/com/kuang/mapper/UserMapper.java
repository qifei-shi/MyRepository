package com.kuang.mapper;


import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    //添加一个用户
    int addUser(User user);
    //删除一个用户
    int deleteUser(@Param("id") int id);

}

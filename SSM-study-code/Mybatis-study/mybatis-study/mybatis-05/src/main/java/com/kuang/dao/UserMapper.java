package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    //方法存在多个参数时必须加上@Param("")注解,向sql中传参是传的@Param("id")中的参数
    // @Select("select * from user where id =  #{id} ")
    //User getUserById(@Param("id") int id,@Param("name") String name);

    @Select("select * from user where id =  #{id} ")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id, name, pwd) value(#{id}, #{name}, #{password})")
    int addUser(User user);

    @Update("update user set name=#{name}, pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete  from user where id =#{uid}")
    int deleteUser(@Param("uid") int id);


}

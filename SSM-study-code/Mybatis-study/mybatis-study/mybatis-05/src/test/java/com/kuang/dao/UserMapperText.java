package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperText {

    @Test
    public void Test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //底层应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();

    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //底层应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User userById = mapper.getUserById(2);

        System.out.println(userById);

        //mapper.addUser( new User(4,"李四","123456"));

        //mapper.updateUser(new User(4,"admin","admin"));

        //mapper.deleteUser(4);

        sqlSession.close();

    }


}

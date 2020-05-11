package com.kuang.dao;


import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class UserDaoText {

    @Test
    public void Test(){
        //第一步：获取sqlSession对象(获取执行sql的对象 )
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        //方式一：推荐方式  getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(2);

        System.out.println("id\t\tname\t\tpassword");


        System.out.println(user.getId()+"\t\t"+user.getName()+"\t\t"+user.getPassword());



        //关闭sqlSession
        sqlSession.close();
    }

    //select * from mybatis.user where id = #{id};
    //类型处理器
    //select id, name, pwd as password from mybatis.user where id = #{id};


}

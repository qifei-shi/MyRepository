package com.kuang.dao;


import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDaoText {

    @Test
    public void Test(){
        //第一步：获取sqlSession对象(获取执行sql的对象 )
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        //方式一：推荐方式  getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        //方式二:不推荐
//        List<User> userList = sqlSession.selectList("cmo.com.kuang.kuang.dao.UserDao.getUserList");
        System.out.println("id\t\tname\t\tpwd");
        for (User user : userList) {
            System.out.print(user.getId()+"\t\t");
            System.out.print(user.getName()+"\t\t");
            System.out.println(user.getPwd());
        }

        //关闭sqlSession
        sqlSession.close();
    }


}

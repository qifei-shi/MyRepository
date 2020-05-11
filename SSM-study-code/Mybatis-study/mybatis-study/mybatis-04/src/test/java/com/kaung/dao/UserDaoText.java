package com.kaung.dao;


import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class UserDaoText {
    static Logger logger = Logger.getLogger(UserDaoText.class);

    @Test
    public void Test(){

        //第一步：获取sqlSession对象(获取执行sql的对象 )
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        logger.info("info获取sqlSession对象");
        //执行sql
        //方式一：推荐方式  getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(2);

        System.out.println("id\t\tname\t\tpassword");

        System.out.println(user.getId()+"\t\t"+user.getName()+"\t\t"+user.getPassword());

        //关闭sqlSession
        sqlSession.close();

    }

    @Test
    public void testLog4j(){
        logger.info("info进入了testLog4j");
        logger.debug("debug进入了testLog4j");
        logger.error("error进入了testLog4j");
    }


    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        List<User> userList = mapper.getUserByLimit(map);
        System.out.println("id\t\tname\t\tpassword");
        for (User user : userList) {
            System.out.println(user.getId()+"\t\t"+user.getName()+"\t\t"+user.getPassword());
        }

        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //使用RowBounds
        RowBounds rowBounds = new RowBounds(1, 2);

        //通过java代码层面实现分页
        List<User> list = sqlSession.selectList("com.com.kuang.kuang.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        System.out.println("id\t\tname\t\tpassword");
        for (User user : list) {
            System.out.println(user.getId()+"\t\t"+user.getName()+"\t\t"+user.getPassword());
        }


    }


}

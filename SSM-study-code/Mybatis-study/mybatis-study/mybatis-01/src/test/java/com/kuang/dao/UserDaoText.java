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
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        System.out.println("id\t\tname\t\tpwd");
        for (User user : userList) {
            System.out.print(user.getId()+"\t\t");
            System.out.print(user.getName()+"\t\t");
            System.out.println(user.getPwd());
        }

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        //获取SQLSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUserById(1);
        System.out.println("id\tname\tpassword");
        System.out.println(user.getId()+"\t"+user.getName()+"\t"+user.getPwd());
        sqlSession.close();
    }

    //增删改需要事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        int res = mapper.addUser(new User(5, "哈哈哈", "123333"));
        if (res > 0) {
            System.out.println("插入成功！");
        }
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int res = mapper.updateUser(new User(4, "呵呵", "111111"));
        if (res > 0){
            System.out.println("更新成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        mapper.deleteUser(5);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void addUserMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("userId",5);
        map.put("userName","hello");
        map.put("password","123456");
        mapper.addUserMap(map);

        sqlSession.commit();

        sqlSession.commit();
    }

}

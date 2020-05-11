package com.kuang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//SqlSessionFactory ---> sqSession
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory ;

     static {
        try {
            //使用mybatis第一步获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        }catch (IOException e){
            e.printStackTrace();
        }

}


   /**
    * 既然有了 SqlSessionFactory;，顾名思义，我们可以从中获得 SqlSession  的实例。
    * SqlSession 提供了在数据库执行SQL 命令所需的所有方法。
    *你可以通过 SqlSession实例来直接执行已映射的 SQL语句。
    *
    */
   public static SqlSession getSqlSession(){
       /**
        * autoCommit
        * 默认为false
        * return sqlSessionFactory.openSession();
        * 当openSession有参数true时，代表自动提交事务。
        *
        * */
       return sqlSessionFactory.openSession(true);
   }

}

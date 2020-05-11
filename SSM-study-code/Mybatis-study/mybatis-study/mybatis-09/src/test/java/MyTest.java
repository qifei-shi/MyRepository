import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utiles.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void queryUsers(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        //当以及缓存失效时二级缓存才会有效

        System.out.println("==========sqlSession============");

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User users = mapper.queryUsers(2);
        System.out.println(users);
        sqlSession.close();

        System.out.println("==========sqlSession2============");


        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUsers(2);
        System.out.println(user2);

        System.out.println(user2==users);


        sqlSession2.close();


    }
}

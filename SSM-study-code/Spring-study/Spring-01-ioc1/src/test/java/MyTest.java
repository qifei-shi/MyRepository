import com.kuang.dao.UserDaoMysqlImpl;
import com.kuang.service.UserService;
import com.kuang.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //获取ApplicationContext  拿到Spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //容器在手，天下我有需要什么就get什么
        UserServiceImpl UserServiceImpl = (com.kuang.service.UserServiceImpl) context.getBean("UserServiceImpl");

        UserServiceImpl.getUser();
    }
}

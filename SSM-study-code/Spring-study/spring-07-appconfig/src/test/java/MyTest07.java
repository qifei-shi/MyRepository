import com.kuang.config.MyConfig;
import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest07 {

    @Test
    public void Test() {
        //如果完全使用了配置类方式去做，我们就只能通过AnnotationConfig. 上下文来获取容器，通过配置类的cLass对象加载!
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User getUser = (User) context.getBean("getUser");
        System.out.println(getUser.getName());
    }
}
import com.kuang.pojo.Student;
import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest04 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Student student = (Student) context.getBean("student");

        System.out.println(student.toString());

        /*
        * Student{name='啊啊啊啊啊',
        * address=Address{address='山东'},
        * books=[水浒, 小王子, 三国],
        * hobbys=[听歌, 喝茶, 唱歌],
        * card={身份ID=1222222222, bankID=323231431423},
        * game=[LOL, COC, DOD],
        * wife='null',
        * info={学号=2222222, 姓名=aaaa}}
        * */
    }

    @Test
    public void Test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) context.getBean("user2");
        User user2 = (User) context.getBean("user2");
        System.out.println(user==user2);

    }
}

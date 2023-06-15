import cloud.zhfsmy.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        //通过get,set注入属性
        User u1 = ac.getBean("user2", User.class);
        System.out.println(u1);
        //通过构造器注入
        User u2 = ac.getBean("user3", User.class);
        System.out.println(u2);
    }
}

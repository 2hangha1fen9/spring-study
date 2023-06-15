import cloud.zhfsmy.User;
import cloud.zhfsmy.UserDAO;
import cloud.zhfsmy.UserDAOImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        //通过id获取bean
        User u1 = (User) ac.getBean("user1");
        u1.sayHello();
        //通过类型获取bean
        User u2 = ac.getBean("user1", User.class);
        u2.sayHello();
        //通过id和类型获取bean
        User u3 = ac.getBean("user1", User.class);
        u3.sayHello();
        //通过接口获取bean
        UserDAO dao = ac.getBean(UserDAOImpl.class);
        dao.listUser();
    }
}

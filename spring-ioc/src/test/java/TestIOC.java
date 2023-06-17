import cloud.zhfsmy.dao.UserDAO;
import cloud.zhfsmy.dao.UserDAOImpl;
import cloud.zhfsmy.entity.User;
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
        //特殊值处理
        User u4 = ac.getBean("user4", User.class);
        User u5 = ac.getBean("user5", User.class);
        System.out.println(u4);
        System.out.println(u5);
        //引用类型注入
        User u6 = ac.getBean("user6", User.class);
        System.out.println(u6);
        //内部bean
        User u7 = ac.getBean("user7", User.class);
        System.out.println(u7);
        //级联赋值
        User u8 = ac.getBean("user8", User.class);
        System.out.println(u8);
        //数组赋值
        User u9 = ac.getBean("user9", User.class);
        System.out.println(u9);
        //集合赋值
        User u10 = ac.getBean("user10", User.class);
        System.out.println(u10);
        //map赋值
        User u11 = ac.getBean("user11", User.class);
        System.out.println(u11);
        //集合引用赋值
        User u12 = ac.getBean("user12", User.class);
        System.out.println(u12);
    }
}

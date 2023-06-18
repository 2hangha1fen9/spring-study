import cloud.zhfsmy.controller.UserController;
import cloud.zhfsmy.dao.UserDAO;
import cloud.zhfsmy.dao.UserDAOImpl;
import cloud.zhfsmy.entity.LifeCycle;
import cloud.zhfsmy.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class TestIOC {
    @Test
    public void test() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
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
        //配置文件引入,注入druid数据源
        DataSource ds = ac.getBean(DataSource.class);
        System.out.println(ds);
        //bean的作用域
        User singletonUser1 = ac.getBean("singletonUser", User.class);
        User singletonUser2 = ac.getBean("singletonUser", User.class);
        User prototypeUser1 = ac.getBean("prototypeUser", User.class);
        User prototypeUser2 = ac.getBean("prototypeUser", User.class);
        System.out.println(singletonUser1 == singletonUser2);
        System.out.println(prototypeUser1 == prototypeUser2);
        //bean的生命周期
        LifeCycle life = ac.getBean("lifeCycle", LifeCycle.class);
        System.out.println(life);
        //FactoryBean
        User u13 = ac.getBean("userFactory", User.class);
        System.out.println(u13);
        //xml自动注入
        //根据类型自动注入
        UserController controller1 = ac.getBean("userControllerByType", UserController.class);
        System.out.println(controller1.getUser());
        //UserController controller2 = ac.getBean("userControllerByName", UserController.class);
        //controller2.getCurrentUser();
    }
}

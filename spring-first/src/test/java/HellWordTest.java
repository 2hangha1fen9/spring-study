import cloud.zhfsmy.HelloWorld;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HellWordTest {
    private final Logger logger = LoggerFactory.getLogger(HellWordTest.class);

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld main = (HelloWorld) context.getBean("helloWorld");
        main.sayHello();
        logger.info("测试log42j日志框架");
    }

    @Test
    public void testReflect() throws Exception {
        Class clazz = Class.forName("cloud.zhfsmy.HelloWorld");
        HelloWorld hello = (HelloWorld) clazz.getDeclaredConstructor().newInstance();
        hello.sayHello();

    }
}

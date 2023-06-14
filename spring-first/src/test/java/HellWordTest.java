import cloud.zhfsmy.HelloWorld;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HellWordTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld main = (HelloWorld) context.getBean("helloWorld");
        main.sayHello();
    }
}

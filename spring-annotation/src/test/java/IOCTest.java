import cloud.zhfsmyScan.SpringConfig;
import cloud.zhfsmyScan.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {
    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController controller = ac.getBean(UserController.class);
        controller.printUser();
    }
}

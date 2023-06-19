import cloud.zhfsmy.myioc.domain.controller.CarController;
import cloud.zhfsmy.myioc.ioc.ApplicationContext;
import cloud.zhfsmy.myioc.ioc.IOCContainer;
import org.junit.jupiter.api.Test;

public class IOCTest {
    @Test
    public void test() throws Exception {
        IOCContainer container = new ApplicationContext("cloud");
        CarController controller = container.getBean(CarController.class);
        controller.printCar();
    }
}

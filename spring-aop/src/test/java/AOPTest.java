import cloud.zhfsmy.aop.Calculator;
import cloud.zhfsmy.aop.CalculatorImpl;
import cloud.zhfsmy.aop.dynamicProxy.ProxyFactory;
import cloud.zhfsmy.aop.statcProxy.CalculatorStaticProxy;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void test() {
        //使用静态代理
        Calculator calculator1 = new CalculatorStaticProxy(new CalculatorImpl());
        //calculator1.add(1, 6);
        //使用动态代理
        ProxyFactory<Calculator> proxyFactory = new ProxyFactory<>(new CalculatorImpl());
        Calculator calculator2 = proxyFactory.getProxyObject();
        //calculator2.add(1, 6);
        //使用AOP
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Calculator calculator3 = ac.getBean(Calculator.class);
        calculator3.add(1, 5);
        //calculator3.div(1, 0);
    }
}

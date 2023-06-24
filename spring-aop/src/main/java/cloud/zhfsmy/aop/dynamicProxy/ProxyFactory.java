package cloud.zhfsmy.aop.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态代理
 */
public class ProxyFactory<T> {
    T proxyTarget;

    /**
     * @param proxyTarget 需要代理的对象
     */
    public ProxyFactory(T proxyTarget) {
        this.proxyTarget = proxyTarget;
    }

    /**
     * 获取被代理的对象
     *
     * @return 被代理的对象
     */
    public T getProxyObject() {
        /*
          newProxyInstance()：创建一个代理实例
          其中有三个参数：
          1、classLoader：加载动态生成的代理类的类加载器
          2、interfaces：目标对象实现的所有接口的class对象所组成的数组
          3、invocationHandler：设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
         */
        ClassLoader classLoader = proxyTarget.getClass().getClassLoader();
        Class<?>[] interfaces = proxyTarget.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * @param proxy 代理对象
             * @param method 代理对象需要实现的方法，即其中需要重写的方法
             * @param args method所对应方法的参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) {
                Object result = null;
                try {
                    System.out.printf("[动态代理日志] 操作方法: %s 参数: %s\n", method.getName(), Arrays.toString(args));
                    result = method.invoke(proxyTarget, args);
                    System.out.printf("[动态代理日志] 操作方法: %s 结果: %s\n", method.getName(), result);
                } catch (Exception e) {
                    System.out.printf("[动态代理日志] 操作方法: %s 异常: %s\n", method.getName(), e.getMessage());
                } finally {
                    System.out.printf("[动态代理日志] 操作方法: %s 执行完毕\n", method.getName());
                }
                return result;
            }
        };

        return (T) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}

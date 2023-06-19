package cloud.zhfsmy.myioc.ioc;

public interface IOCContainer {
    //根据类型获取Bean
    <T> T getBean(Class clazz);
}

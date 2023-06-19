package cloud.zhfsmy.myioc.ioc;

import cloud.zhfsmy.myioc.ioc.annotation.Bean;
import cloud.zhfsmy.myioc.ioc.annotation.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext implements IOCContainer {
    private final Logger logger = LoggerFactory.getLogger(ApplicationContext.class);
    //Bean容器
    private Map<Class, Object> objects = new HashMap<>();
    private String packageName;

    public ApplicationContext(String packageName) throws Exception {
        //将包名的.替换为/
        packageName = packageName.replaceAll("\\.", "/");
        this.packageName = packageName;
        //获取包名的全路径
        URL url = this.getClass().getClassLoader().getResource(packageName);
        if (url != null) {
            scanPackage(new File(url.getPath()));
        }
        logger.info("扫描完毕,加载Bean数量: {}", objects.size());
        //对容器的对象进行自动依赖注入
        autoInject();
    }

    //扫描指定文件夹的所有文件
    private void scanPackage(File file) throws Exception {
        //如果是文件,就判断是否是类文件,并加载进容器
        if (file.isFile()) {
            //获取全路径,并替换为全包名
            String path = file.getCanonicalPath();
            String fullClassName = path.substring(path.indexOf(packageName)).replaceAll("/", ".").replace(".class", "");
            //获取Class对象
            Class clazz = Class.forName(fullClassName);
            //将普通类型放入容器
            if (!clazz.isInterface() && !clazz.isAnnotation() && !clazz.isEnum()) {
                //只将含有@Bean注解的类添加到容器
                if (clazz.getAnnotation(Bean.class) != null) {
                    Object bean = clazz.getDeclaredConstructor().newInstance();
                    //判断是否有实现的接口,如果有就添加接口的类型为map的Key
                    if (clazz.getInterfaces().length > 0) {
                        objects.put(clazz.getInterfaces()[0], bean);
                    } else {
                        objects.put(clazz, bean);
                    }
                    logger.info("成功加载Bean : {}", fullClassName);
                }
            }
        } else {
            //如果为文件夹继续递归
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    scanPackage(f);
                }
            }
        }
    }

    //对已注册的Bean进行自动装配
    private void autoInject() throws Exception {
        for (Map.Entry<Class, Object> entry : objects.entrySet()) {
            //获取要装配的对象
            Object object = entry.getValue();
            //判断类属性上是否有@Inject注解
            Class clazz = object.getClass();
            //获取所有成员属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {

                if (field.getAnnotation(Inject.class) != null) {
                    //设置最高访问权限
                    field.setAccessible(true);
                    field.set(object, objects.get(field.getType()));
                }
            }
        }
    }

    //根据类型获取Bean
    @Override
    public <T> T getBean(Class clazz) {
        return (T) objects.get(clazz);
    }
}

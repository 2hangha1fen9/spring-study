package cloud.zhfsmy.myioc.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//设置注解作用的位置,并设置运行时保留
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Bean {
    
}

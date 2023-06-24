package cloud.zhfsmy.aop.aopProxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志切面类
 */
@Aspect
@Component
public class LoggerAOP {
    /**
     * 定义可以重复使用的切入点表达式
     */
    @Pointcut("execution(public * cloud.zhfsmy.aop.CalculatorImpl.*(..))")
    public void pointCut(JoinPoint joinPoint) {
        System.out.println("可重用的切入点表达式");
    }

    /**
     * 方法执行之前执行
     */
    @Before("execution(public * cloud.zhfsmy.aop.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.printf("[Before切入点] 操作方法: %s 参数: %s\n", name, Arrays.toString(args));
    }

    /**
     * 方法返回之前执行
     */
    @AfterReturning(value = "execution(public * cloud.zhfsmy.aop.CalculatorImpl.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        //这里可以修改方法返回值
        //result = (Integer) result + 10;
        System.out.printf("[AfterReturning切入点] 操作方法: %s 参数: %s 返回结果: %s\n", name, Arrays.toString(args), result);
    }

    /**
     * 方法异常之后
     */
    @AfterThrowing(value = "execution(public * cloud.zhfsmy.aop.CalculatorImpl.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.printf("[AfterThrowing切入点] 操作方法: %s 异常: %s\n", name, ex);

    }

    /**
     * 方法返回之后执行
     */
    @After("execution(public * cloud.zhfsmy.aop.CalculatorImpl.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.printf("[After切入点] 操作方法: %s\n", name);
    }

    /**
     * 方法执行的每个阶段都可以设置切面方法,相当于灵活配置切入点
     */
    @Around(value = "execution(public * cloud.zhfsmy.aop.CalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("------------------before环绕------------------");
            result = joinPoint.proceed();
            System.out.println("--------------afterReturning环绕--------------");
        } catch (Throwable e) {
            System.out.println("---------------afterThrowing环绕--------------");
            throw new RuntimeException(e);
        } finally {
            System.out.println("------------------after环绕-------------------");
        }
        return result;
    }


}

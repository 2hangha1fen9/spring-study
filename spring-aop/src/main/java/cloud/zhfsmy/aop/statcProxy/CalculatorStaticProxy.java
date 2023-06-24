package cloud.zhfsmy.aop.statcProxy;

import cloud.zhfsmy.aop.Calculator;

//代理对象需要实现被代理类相同的方法
public class CalculatorStaticProxy implements Calculator {
    //需要被代理的对象
    private Calculator proxyTarget;

    public CalculatorStaticProxy(Calculator proxyTarget) {
        this.proxyTarget = proxyTarget;
    }

    @Override
    public int add(int a, int b) {
        System.out.printf("[静态代理日志] 操作方法: add 参数: %s %s\n", a, b);
        int result = proxyTarget.add(a, b);
        System.out.printf("[静态代理日志] 操作方法: add 结果: %s\n", result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        System.out.printf("[静态代理日志] 操作方法: sub 参数: %s %s\n", a, b);
        int result = proxyTarget.sub(a, b);
        System.out.printf("[静态代理日志] 操作方法: sub 结果: %s\n", result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        System.out.printf("[静态代理日志] 操作方法: mul 参数: %s %s\n", a, b);
        int result = proxyTarget.mul(a, b);
        System.out.printf("[静态代理日志] 操作方法: mul 结果: %s\n", result);
        return result;
    }

    @Override
    public int div(int a, int b) {
        System.out.printf("[静态代理日志] 操作方法: div 参数: %s %s\n", a, b);
        int result = proxyTarget.div(a, b);
        System.out.printf("[静态代理日志] 操作方法: div 结果: %s\n", result);
        return result;
    }
}

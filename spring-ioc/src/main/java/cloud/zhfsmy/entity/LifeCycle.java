package cloud.zhfsmy.entity;

public class LifeCycle {
    private String name;

    public LifeCycle() {
        System.out.println("生命周期：1、创建对象");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("生命周期：2、依赖注入");
        this.name = name;
    }

    public void initMethod() {
        System.out.println("生命周期：3、初始化");
    }

    public void destroyMethod() {
        System.out.println("生命周期：5、销毁");
    }

    @Override
    public String toString() {
        return "LifeCycle{" +
                "name='" + name + '\'' +
                '}';
    }
}

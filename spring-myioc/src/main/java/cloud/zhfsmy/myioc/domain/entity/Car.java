package cloud.zhfsmy.myioc.domain.entity;

public class Car {
    private String name;
    private String color;
    private String num;

    public Car(String name, String color, String num) {
        this.name = name;
        this.color = color;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}

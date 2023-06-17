package cloud.zhfsmy.entity;

public class Mobile {
    private String number;
    private String isp;

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "number='" + number + '\'' +
                ", isp='" + isp + '\'' +
                '}';
    }
}

package cloud.zhfsmy.myioc.domain.dao.impl;

import cloud.zhfsmy.myioc.domain.dao.CarDAO;
import cloud.zhfsmy.myioc.domain.entity.Car;
import cloud.zhfsmy.myioc.ioc.annotation.Bean;

@Bean
public class CarDAOImpl implements CarDAO {
    @Override
    public Car getCar() {
        return new Car("宝马", "白色", "1232323");
    }
}

package cloud.zhfsmy.myioc.domain.service.impl;

import cloud.zhfsmy.myioc.domain.dao.CarDAO;
import cloud.zhfsmy.myioc.domain.entity.Car;
import cloud.zhfsmy.myioc.domain.service.CarService;
import cloud.zhfsmy.myioc.ioc.annotation.Bean;
import cloud.zhfsmy.myioc.ioc.annotation.Inject;

@Bean
public class CarServiceImpl implements CarService {
    @Inject
    private CarDAO carDAO;

    @Override
    public Car getCarInfo() {
        return carDAO.getCar();
    }
}

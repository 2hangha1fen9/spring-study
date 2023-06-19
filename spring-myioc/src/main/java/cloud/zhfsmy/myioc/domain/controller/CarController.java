package cloud.zhfsmy.myioc.domain.controller;

import cloud.zhfsmy.myioc.domain.service.CarService;
import cloud.zhfsmy.myioc.ioc.annotation.Bean;
import cloud.zhfsmy.myioc.ioc.annotation.Inject;

@Bean
public class CarController {
    @Inject
    private CarService carService;

    public void printCar() {
        System.out.println(carService.getCarInfo());
    }
}

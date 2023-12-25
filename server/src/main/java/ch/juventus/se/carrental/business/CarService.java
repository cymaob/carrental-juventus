package ch.juventus.se.carrental.business;

import ch.juventus.se.carrental.persistance.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    public Car createCar(Car newCar){
        return CarRepository.getInstance().putCar(newCar);
    }

    public Car deleteCar(Car oldCar) {
        return CarRepository.getInstance().deleteCar(oldCar);
    }
}
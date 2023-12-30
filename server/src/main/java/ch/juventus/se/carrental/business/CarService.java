package ch.juventus.se.carrental.business;

import ch.juventus.se.carrental.persistance.CarRepository;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.Collection;

@Service
public class CarService {
    public Car createCar(Car newCar){
        return CarRepository.getInstance().putCar(newCar);
    }

    public Car deleteCar(Car oldCar) {
        return CarRepository.getInstance().deleteCar(oldCar);
    }

    public Car getCar(int car) {
        return CarRepository.getInstance().getCar(car);
    }

    public Collection<Car> getAllCars() {
        return CarRepository.getInstance().getAllCars();
    }
}
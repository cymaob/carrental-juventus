package ch.juventus.se.carrental.business;

import ch.juventus.se.carrental.application.CarController;
import ch.juventus.se.carrental.persistance.CarRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CarService {
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);
    private final CarRepo carRepo;
    @Autowired
    public CarService(CarRepo carRepo){
        this.carRepo = carRepo;
    }

    public Collection<Car> getAllCars() {
        return carRepo.findAll();
    }

    public Car getCar(int id){
        return carRepo.getReferenceById(id);
    }

    public Car saveCar(Car car){
        return carRepo.save(car);
    }

    public Car updateCar(Car car){
        Car carToUpdate = carRepo.getReferenceById(car.id);
        carToUpdate.brand=car.brand;
        carToUpdate.model=car.model;
        carToUpdate.doors=car.doors;
        carToUpdate.seats=car.seats;
        carToUpdate.transmission=car.transmission;
        carToUpdate.chassis=car.chassis;
        carToUpdate.pricePerDay=car.pricePerDay;
        return carRepo.save(carToUpdate);
    }

    public void deleteCar(int id){
        carRepo.deleteById(id);
    }

}

package ch.juventus.se.carrental.business;

import ch.juventus.se.carrental.application.CarController;
import ch.juventus.se.carrental.persistance.CarRepo;
import ch.juventus.se.carrental.persistance.RentalRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Service
public class CarService {
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);
    private final CarRepo carRepo;
    private final RentalRepo rentalRepo;

    @Autowired
    public CarService(CarRepo carRepo, RentalRepo rentalRepo){
        this.carRepo = carRepo;
        this.rentalRepo = rentalRepo;
    }

    public Collection<Car> getAllCars() {
        return carRepo.findAll();
    }

    public Collection<Car> getAvailableCars(LocalDate startDate, LocalDate endDate){
        if (startDate == null && endDate == null){
            return carRepo.findAll();
        } else if (startDate != null && endDate != null) {
            return rentalRepo.findAvailableCars(startDate, endDate);
        } else {
            throw new IllegalArgumentException("Start and end date must be provided. No params for all cars");
        }
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

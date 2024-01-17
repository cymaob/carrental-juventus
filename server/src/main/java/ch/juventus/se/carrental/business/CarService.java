package ch.juventus.se.carrental.business;

import ch.juventus.se.carrental.application.CarController;
import ch.juventus.se.carrental.exceptions.InvalidDateRangeException;
import ch.juventus.se.carrental.persistance.CarRepo;
import ch.juventus.se.carrental.persistance.RentalRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

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

    public Collection<Car> getAllCars(){
        return carRepo.findAll();
    }

    public Collection<Car> getAvailableCars(LocalDateTime startDate, LocalDateTime endDate){
        if (startDate.isBefore(endDate) || startDate.isEqual(endDate)) {
            return rentalRepo.findAvailableCars(startDate, endDate);
        } else {
            logger.warn("End date of request was before start date");
            throw new InvalidDateRangeException("Start date has to be before end date");
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

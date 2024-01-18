package ch.juventus.se.carrental.business;

import ch.juventus.se.carrental.persistance.CarRepo;
import ch.juventus.se.carrental.persistance.RentalRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    private Car car1;
    private Car car2;
    private Car car3;


    private CarRepo carRepo;
    private CarService carService;
    private RentalRepo rentalRepo;

    @BeforeEach
    void setUp(){
        carService = new CarService(carRepo, rentalRepo);
    }

    @BeforeEach
    void saveSomeCars(){
        Car car1 = new Car("Seat", "Leon Cupra", 5, 5, "Automatic", "Hatchback", 200);
        Car car2 = new Car("BMW", "3 Series", 5, 5, "Manual", "Sedan", 50.0);
        Car car3 = new Car("Volvo", "XC40", 5, 5, "Automatic", "SUV", 100.0);

        carRepo.save(car1);
        carRepo.save(car2);
        carRepo.save(car3);
    }

    @Test
    void getAllCars() {
        Collection<Car> cars = carService.getAllCars();

        assertEquals(3, cars.size());
        assertTrue(cars.contains(this.car1));
        assertTrue(cars.contains(this.car2));
        assertTrue(cars.contains(this.car3));

    }

    @Test
    void getAvailableCars() {
    }

    @Test
    void getCar() {
    }

    @Test
    void saveCar() {
    }

    @Test
    void updateCar() {
    }

    @Test
    void deleteCar() {
    }
}
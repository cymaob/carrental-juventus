package ch.juventus.se.carrental.application;

import ch.juventus.se.carrental.business.Car;
import ch.juventus.se.carrental.business.CarService;
import ch.juventus.se.carrental.persistance.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @CrossOrigin("*")
    @GetMapping("")
    public Collection<Car> getAllCars(){
        return CarRepository.getInstance().getAllCars();
    }

    @CrossOrigin("*")
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Integer id){
        return CarRepository.getInstance().getCar(id);
    }

    @CrossOrigin("*")
    @PostMapping(path="",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> createCars(@RequestBody List<Car> newCars) throws ServerException {
        List<Car> cars = new ArrayList<>();
        for (Car newCar : newCars) {
            Car car = carService.createCar(newCar);
            if (car != null) {
                cars.add(car);
            }
        }

        if (cars.isEmpty()) {
            throw new ServerException("Failed to create a car");
        } else {
            return new ResponseEntity<>(cars, HttpStatus.CREATED);
        }
    }

    @CrossOrigin("*")
    @DeleteMapping(path="",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Car>> deleteCar(@RequestBody List<Car> oldCars) throws ServerException {
        List<Car> deletedCars = new ArrayList<>();
        for (Car oldCar : oldCars) {
            Car car = carService.deleteCar(oldCar);
            if (car != null) {
                deletedCars.add(car);
            }
        }

        if (deletedCars.isEmpty()) {
            throw new ServerException("Failed to delete a car");
        } else {
            return new ResponseEntity<>(getAllCars(),HttpStatus.OK);
        }

    }

}

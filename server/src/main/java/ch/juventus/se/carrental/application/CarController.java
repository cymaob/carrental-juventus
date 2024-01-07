package ch.juventus.se.carrental.application;

import ch.juventus.se.carrental.business.Car;
import ch.juventus.se.carrental.business.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
            private CarService carService;
    @CrossOrigin("*")
    @GetMapping(path = "")
    public Collection<Car> getAllCars(){
        logger.debug("Get Request to return all cars");
        return carService.getAllCars();
    }

    @CrossOrigin("*")
    @GetMapping(path = "/{id}")
    public Car getCarById(@PathVariable Integer id){
        logger.debug("Get Request to return car by id: " + id);
        return carService.getCar(id);
    }

    @CrossOrigin("*")
    @PostMapping(path = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> createCars(@RequestBody List<Car> newCars) throws ServerException {
        List<Car> cars = new ArrayList<>();
        for (Car newCar : newCars) {
            Car car = carService.saveCar(newCar);
            if (car != null) {
                cars.add(car);
            }
        }

        if (cars.isEmpty()) {
            logger.error("Failed to create a car");
            throw new ServerException("Failed to create a car");
        } else {
            logger.info("Created car(s)");
            return new ResponseEntity<>(cars, HttpStatus.CREATED);
        }
    }

    @CrossOrigin("*")
    @DeleteMapping(path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteCar(@PathVariable Integer id){
        logger.debug("Delete Request to delete car with ID: " + id);
        carService.deleteCar(id);
        return("[]");
    }

/*

    @CrossOrigin("*")
    @DeleteMapping(path = "",
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
            logger.error("Failed to delete the car(s)");
            throw new ServerException("Failed to delete a car");
        } else {
            logger.info("deleted cars with IDs: " + deletedCars);
            return new ResponseEntity<>(getAllCars(),HttpStatus.OK);
        }

    }
*/

}

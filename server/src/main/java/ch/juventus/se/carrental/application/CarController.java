package ch.juventus.se.carrental.application;

import ch.juventus.se.carrental.business.Car;
import ch.juventus.se.carrental.business.CarService;
import ch.juventus.se.carrental.exceptions.InvalidDateParamException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.rmi.ServerException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/cars")
@Tag(name = "Car")
public class CarController {
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
            private CarService carService;

    @Operation(
            summary = "Get all cars",
            description = "If no parameters are set, all cars will be returned. Additionally, startDate and endDate can be specified to only return cars, which are available in the given time.",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400"
                    )
            }
    )
    @GetMapping(path = "",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Car> getAvailableCars(@RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate){
        logger.debug("Get Request to return all cars");
        if (startDate == null && endDate ==null) {
            return carService.getAllCars();
        } else if (startDate == null || endDate == null) {
            throw new InvalidDateParamException("");
        } else {
            return carService.getAvailableCars(startDate, endDate);
        }

    }

    @Operation(
            summary = "Get car by ID",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    )
            }
    )
    @GetMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Car getCarById(@PathVariable Integer id){
        logger.debug("Get Request to return car by id: " + id);
        return carService.getCar(id);
    }

    @Operation(
            summary = "Create one or multiple new car(s)",
            responses = {
                    @ApiResponse(
                            description = "Created",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400"
                    )
            }
    )
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


    @Operation(
            summary = "Update an existing car",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    )
            }
    )
    @PutMapping(path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Car updateCar(@RequestBody Car car, @PathVariable Integer id) throws ServerException{
        return carService.updateCar(car);
    }

    @Operation(
            summary = "Delete car by Id",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    )
            }
    )
    @DeleteMapping(path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteCar(@PathVariable Integer id){
        logger.debug("Delete Request to delete car with ID: " + id);
        carService.deleteCar(id);
        return("[]");
    }

}

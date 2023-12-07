package ch.juventus.se.carrental.application;

import ch.juventus.se.carrental.business.Car;

import ch.juventus.se.carrental.persistance.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    @CrossOrigin("*")
    @GetMapping("/")
    public Collection<Car> getAllCars(){
        return CarRepository.getInstance().getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Integer id){
        return CarRepository.getInstance().getCar(id);
    }


}

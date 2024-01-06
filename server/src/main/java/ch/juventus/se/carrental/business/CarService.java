package ch.juventus.se.carrental.business;

import ch.juventus.se.carrental.persistance.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CarService {
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

    public void deleteCar(int id){
        carRepo.deleteById(id);
    }

}

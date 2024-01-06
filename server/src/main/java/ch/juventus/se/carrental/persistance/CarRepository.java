package ch.juventus.se.carrental.persistance;

import ch.juventus.se.carrental.business.Car;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public class CarRepository {

    private Map<Integer, Car> carMap = new HashMap<>();

    //this class is a singleton and should not be instantiated directly!
    private static CarRepository instance = new CarRepository();
    public static CarRepository getInstance(){
        return instance;
    }

    private CarRepository(){
        carMap.put(1, new Car("Seat", "Leon", 4, 4, "Automatic", "Hatchback", 170.0));
        carMap.put(2, new Car("VW", "Golf", 4, 4, "Manual", "Hatchback", 150.0));
        carMap.put(3, new Car("Volvo", "XC40", 5, 5, "Automatic", "SUV", 200.0));
        carMap.put(4, new Car("Audi", "RS8", 3, 2, "Automatic", "Sports car", 199.0));
        carMap.put(5, new Car("Toyota", "Camry", 4, 4, "Automatic", "Sedan", 150.0));
        carMap.put(6, new Car( "Ford", "Mustang", 2, 2, "Manual", "Sports car", 250.0));
        carMap.put(7, new Car("Honda", "Civic", 4, 4, "Automatic", "Sedan", 130.0));
    }

    public Car getCar(Integer id){
        return carMap.get(id);
    }

    public Car putCar(Car car){
        carMap.put(car.getId(), car);
        return car;
    }

    public Collection<Car> getAllCars(){
        return carMap.values();
    }

    public Car deleteCar(Car oldCar) {
        return carMap.remove(oldCar.getId());
    }
}

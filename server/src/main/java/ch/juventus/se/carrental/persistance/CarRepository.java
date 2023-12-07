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
        carMap.put(1, new Car(1, "Seat", "Leon"));
        carMap.put(2, new Car(2, "VW", "Golf"));
        carMap.put(3, new Car(3, "Volvo", "XC40"));
    }

    public Car getCar(Integer id){
        return carMap.get(id);
    }

    public void putCar(Car car){
        carMap.put(car.getId(), car);
    }

    public Collection<Car> getAllCars(){
        return carMap.values();
    }

}

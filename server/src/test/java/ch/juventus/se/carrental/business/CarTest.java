package ch.juventus.se.carrental.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarTest {

    private Car car;

    @BeforeEach
    public void createCar() {
        car = new Car("BMW", "3 Series", 4, 5, "Manual", "Sedan", 50.0);
    }

    @Test
    public void testConstructor() {
        assertEquals("BMW", car.getBrand());
        assertEquals("3 Series", car.getModel());
        assertEquals(4, car.getDoors());
        assertEquals(5, car.getSeats());
        assertEquals("Manual", car.getTransmission());
        assertEquals("Sedan", car.getChassis());
        assertEquals(50.0, car.getPricePerDay());
    }

    @Test
    public void testSettersAndGetters() {
        car.setBrand("Audi");
        assertEquals("Audi", car.getBrand());

        car.setModel("TT");
        assertEquals("TT", car.getModel());

        car.setDoors(2);
        assertEquals(2, car.getDoors());

        car.setSeats(2);
        assertEquals(2, car.getSeats());

        car.setTransmission("Manual");
        assertEquals("Manual", car.getTransmission());

        car.setChassis("Wagon");
        assertEquals("Wagon", car.getChassis());

        car.setPricePerDay(199.95);
        assertEquals(199.95, car.getPricePerDay());
    }

    @Test
    public void testDefaultConstructor() {
        Car defaultCar = new Car();
        assertNotNull(defaultCar);
    }
}

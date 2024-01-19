package ch.juventus.se.carrental.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {
    private Car car;
    private final LocalDateTime startDate = LocalDateTime.now();
    private final LocalDateTime endDate = startDate.plusDays(7);
    private Rental rental;


    @BeforeEach
    public void createRental(){
        this.car = new Car("BMW", "3 Series", 4, 5, "Manual", "Sedan", 50.0);
        rental = new Rental(car, startDate, endDate);
    }


    @Test
    public void testConstructor(){
        assertEquals(car, rental.getCar());
        assertEquals(startDate, rental.getRentStartDate());
        assertEquals(endDate, rental.getRentEndDate());
    }

    @Test
    void testSettersAndGetters() {
        rental.setId(1);
        assertEquals(1, rental.getId());

        rental.setRentStartDate(startDate);
        assertEquals(startDate, rental.getRentStartDate());

        rental.setRentEndDate(endDate);
        assertEquals(endDate, rental.getRentEndDate());
    }

}
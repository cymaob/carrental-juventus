package ch.juventus.se.carrental.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private Rental rental;

    @BeforeEach
    public void createRental(){
        this.car = new Car("BMW", "3 Series", 4, 5, "Manual", "Sedan", 50.0);
        this.startDate = LocalDate.now();
        this.endDate = startDate.plusDays(7);

        rental = new Rental(car, startDate, endDate);
    }

    @Test
    public void testConstructor(){
        assertEquals(car, rental.getCar());
        assertEquals(startDate, rental.getRentStartDate());
        assertEquals(endDate, rental.getRentEndDate());
    }

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getRentStartDate() {
    }

    @Test
    void setRentStartDate() {
    }

    @Test
    void getRentEndDate() {
    }

    @Test
    void setRentEndDate() {
    }

    @Test
    void getCar() {
    }
}
package ch.juventus.se.carrental.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;

    private LocalDate rentStartDate;
    private LocalDate rentEndDate;

    public Rental(Car car, LocalDate rentStartDate, LocalDate rentEndDate) {
        this.car = car;
        this.rentStartDate = rentStartDate;
        this.rentEndDate = rentEndDate;
    }

    public Rental() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(LocalDate rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public LocalDate getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(LocalDate rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public Car getCar(){
        return this.car;
    }
}

package ch.juventus.se.carrental.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;

    private LocalDateTime rentStartDate;
    private LocalDateTime rentEndDate;

    public Rental(Car car, LocalDateTime rentStartDate, LocalDateTime rentEndDate) {
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

    public LocalDateTime getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(LocalDateTime rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public LocalDateTime getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(LocalDateTime rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public Car getCar(){
        return this.car;
    }
}

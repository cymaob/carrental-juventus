package ch.juventus.se.carrental.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Rental {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    private LocalDate rentStartDate;
    private LocalDate rentEndDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package ch.juventus.se.carrental.persistance;

import ch.juventus.se.carrental.business.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {
}

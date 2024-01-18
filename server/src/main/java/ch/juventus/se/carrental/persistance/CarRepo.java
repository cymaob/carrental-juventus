package ch.juventus.se.carrental.persistance;

import ch.juventus.se.carrental.business.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {
}

package ch.juventus.se.carrental.persistance;

import ch.juventus.se.carrental.business.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepo extends JpaRepository<Rental, Integer> {
}

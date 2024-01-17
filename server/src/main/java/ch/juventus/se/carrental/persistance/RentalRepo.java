package ch.juventus.se.carrental.persistance;

import ch.juventus.se.carrental.business.Car;
import ch.juventus.se.carrental.business.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface RentalRepo extends JpaRepository<Rental, Integer> {
    @Query("SELECT c FROM Car c WHERE c.id NOT IN (SELECT r.car.id FROM Rental r WHERE ((r.rentStartDate <= :startDate AND r.rentEndDate >= :startDate) OR (r.rentStartDate <= :endDate AND r.rentEndDate >= :endDate) OR (r.rentStartDate >= :startDate AND r.rentEndDate <= :endDate)))")
    Collection<Car> findAvailableCars(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}

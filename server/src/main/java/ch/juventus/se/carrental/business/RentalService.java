package ch.juventus.se.carrental.business;

import ch.juventus.se.carrental.persistance.RentalRepo;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Service
public class RentalService {
    private static final Logger logger = LoggerFactory.getLogger(RentalService.class);
    private final RentalRepo rentalRepo;
    @Autowired
    public RentalService(RentalRepo rentalRepo){
        this.rentalRepo = rentalRepo;
    }


    public Collection<Rental> getAllRentals(){
        return rentalRepo.findAll();
    }

    public Rental getRentalById(int id){
        return rentalRepo.getReferenceById(id);
    }

    @Transactional
    public Rental newRental(@PathVariable Rental rental){
        return rentalRepo.save(rental);
    }
}

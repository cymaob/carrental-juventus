package ch.juventus.se.carrental.application;

import ch.juventus.se.carrental.business.Rental;
import ch.juventus.se.carrental.business.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/rentals")
public class RentalController {
    private static final Logger logger = LoggerFactory.getLogger(RentalController.class);

    @Autowired
    private RentalService rentalService;

    @GetMapping(path = "")
    public Collection<Rental> getAllRentals(){
        return rentalService.getAllRentals();
    }
}

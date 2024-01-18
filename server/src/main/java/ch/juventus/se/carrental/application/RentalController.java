package ch.juventus.se.carrental.application;

import ch.juventus.se.carrental.business.Rental;
import ch.juventus.se.carrental.business.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/rentals")
@Tag(name = "Rental")
public class RentalController {
    private static final Logger logger = LoggerFactory.getLogger(RentalController.class);

    @Autowired
    private RentalService rentalService;

    @Operation(
            summary = "Get all rentals",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    )
            }
    )
    @GetMapping(path = "",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Rental> getAllRentals() {
        logger.info("Get request to get all rentals");
        return rentalService.getAllRentals();
    }

    @Operation(
            summary = "Get a rental by ID",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    )
            }
    )
    @GetMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Rental getRentalById(@PathVariable Integer id) {
        logger.info("Get request to get rental with ID: " + id);
        return rentalService.getRentalById(id);
    }

    @Operation(
            summary = "Create a new rental",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    )
            }
    )
    @PostMapping(path = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Rental newRental(@RequestBody Rental rental) {
        logger.info("Post request for a new rental");
        return rentalService.newRental(rental);
    }
}
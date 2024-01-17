package ch.juventus.se.carrental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Start date should be before end date")
public class InvalidDateRangeException extends RuntimeException{
    public InvalidDateRangeException(String message){
        super(message);
    }
}

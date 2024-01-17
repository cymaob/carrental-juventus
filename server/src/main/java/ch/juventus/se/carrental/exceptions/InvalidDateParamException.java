package ch.juventus.se.carrental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Start and end date need to be provided")
public class InvalidDateParamException extends RuntimeException{
    public InvalidDateParamException(String message){
        super(message);
    }
}

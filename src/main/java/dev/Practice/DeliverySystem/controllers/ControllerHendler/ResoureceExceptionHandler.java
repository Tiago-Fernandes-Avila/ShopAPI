package dev.Practice.DeliverySystem.controllers.ControllerHendler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.Practice.DeliverySystem.model.services.servicesexceptions.DataBaseException;
import dev.Practice.DeliverySystem.model.services.servicesexceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResoureceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "resource not found";
        StandardError err = new StandardError(Instant.now(),status, error, e.getMessage(),request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> DatabaseErr(DataBaseException e, HttpServletRequest request){
        
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String error = "Database error";
        StandardError err = new StandardError(Instant.now(),status, error, e.getMessage(),request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    
}

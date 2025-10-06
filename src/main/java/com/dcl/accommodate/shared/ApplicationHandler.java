package com.dcl.accommodate.shared;

import com.dcl.accommodate.exception.UserRegistrationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleFailedPersistException(UserRegistrationException userRegistrationException){
        ErrorStructure es = new ErrorStructure();
        es.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        es.setMessage(userRegistrationException.getError());

        return new ResponseEntity<>(es,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

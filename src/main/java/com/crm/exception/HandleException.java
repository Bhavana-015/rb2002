package com.crm.exception;

import com.crm.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.xml.crypto.Data;
import java.util.Date;

@ControllerAdvice
public class HandleException {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> handleEmployeeNotFoundException(
            ResourceNotFound e,
            WebRequest request
    ){
        ErrorDetails errorDetails=new ErrorDetails(
                e.getMessage(),
                new Date(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

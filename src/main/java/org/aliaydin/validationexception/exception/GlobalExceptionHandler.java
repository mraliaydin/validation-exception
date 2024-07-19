package org.aliaydin.validationexception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Request Validation Handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handleInvalidArgument(MethodArgumentNotValidException exception){
        Map<String, String> error = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            error.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setLocalDateTime(LocalDateTime.now());
        errorDetails.setMessage("Validation Failed");
        errorDetails.setErrorCode("400");
        errorDetails.setFieldErrors(error);

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException exception){
        Map<String, String> error = new HashMap<>();
        error.put("Error Detail", exception.getMessage());

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setLocalDateTime(LocalDateTime.now());
        errorDetails.setMessage("User Not Found...");
        errorDetails.setErrorCode("400");
        errorDetails.setFieldErrors(error);

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}

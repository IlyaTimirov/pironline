package ru.api.pir.api.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.api.pir.api.exceptions.CompanyNotFoundException;
import ru.api.pir.api.exceptions.EmployeeNotFoundException;
import ru.api.pir.api.exceptions.Error;
import ru.api.pir.api.exceptions.PositionNotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> resolveHandle(MethodArgumentNotValidException e){
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error ->{
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName ,message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<Error> resolveHandle(CompanyNotFoundException e) {
        return new ResponseEntity<>(Error.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Error> resolveHandle(EmployeeNotFoundException e) {
        return new ResponseEntity<>(Error.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PositionNotFoundException.class)
    public ResponseEntity<Error> resolveHandle(PositionNotFoundException e) {
        return new ResponseEntity<>(Error.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }
}

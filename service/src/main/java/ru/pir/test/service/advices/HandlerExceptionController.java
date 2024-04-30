package ru.pir.test.service.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.pir.test.service.exceptions.EmployeeNotFoundException;
import ru.pir.test.service.exceptions.Error;
import ru.pir.test.service.exceptions.PositionNotFoundException;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Error> resolveHandle(EmployeeNotFoundException e) {
        return new ResponseEntity<>(Error.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PositionNotFoundException.class)
    public ResponseEntity<Error> resolveHandle(PositionNotFoundException e) {
        return new ResponseEntity<>(Error.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }
}

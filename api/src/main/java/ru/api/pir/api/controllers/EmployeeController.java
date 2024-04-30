package ru.api.pir.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.api.pir.api.dto.EmployeeDto;
import ru.api.pir.api.dto.PositionDto;
import ru.api.pir.api.services.EmployeeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees/")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody EmployeeDto employeeDto) {
        employeeService.add(employeeDto);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id) {
        employeeService.remove(id);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/position/update")
    public ResponseEntity<?> positionUpdate(@RequestBody PositionDto positionDto){
        employeeService.updatePosition(positionDto);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}

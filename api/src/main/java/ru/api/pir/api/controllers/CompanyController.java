package ru.api.pir.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.api.pir.api.dto.CompanyDto;
import ru.api.pir.api.services.CompanyService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies/")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CompanyDto companyDto) {
        companyService.save(companyDto);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }
}

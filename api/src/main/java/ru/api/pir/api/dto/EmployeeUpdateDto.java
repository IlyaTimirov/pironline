package ru.api.pir.api.dto;

import lombok.Data;

@Data
public class EmployeeUpdateDto {
    private Long id;

    private String name;

    private double salary;
}

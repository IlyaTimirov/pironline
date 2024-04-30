package ru.api.pir.api.utils;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ru.api.pir.api.dto.EmployeeDto;
import ru.api.pir.api.models.Employee;

@Mapper(componentModel = "spring")
@Component
public interface EmployeeMapper {
    @Mapping(target = "dateOfBirth", expression = "java(employeeDto.getDateOfBirth().toInstant().toEpochMilli())")
    @Mapping(target = "dateAppointment", expression = "java(employeeDto.getDateAppointment().toInstant().toEpochMilli())")
    Employee dtoToEmployee(EmployeeDto employeeDto);

}

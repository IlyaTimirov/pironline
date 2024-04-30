package ru.pir.test.service.utils;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.pir.test.service.models.Employee;
import ru.pir.test.service.models.kafka.PhaseEmployee;

@Mapper(componentModel = "spring")
@Component
public interface EmployeeMapper {
    Employee phaseToEmployee(PhaseEmployee phaseEmployee);

}

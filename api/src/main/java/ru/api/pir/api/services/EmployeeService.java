package ru.api.pir.api.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.api.pir.api.dto.EmployeeDto;
import ru.api.pir.api.dto.PositionDto;
import ru.api.pir.api.exceptions.CompanyNotFoundException;
import ru.api.pir.api.exceptions.EmployeeNotFoundException;
import ru.api.pir.api.models.Company;
import ru.api.pir.api.models.Employee;
import ru.api.pir.api.models.Position;
import ru.api.pir.api.repositories.CompanyRepository;
import ru.api.pir.api.repositories.EmployeeRepository;
import ru.api.pir.api.repositories.PositionRepository;
import ru.api.pir.api.utils.EmployeeMapper;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    private final CompanyService companyService;
    private final PositionService positionService;
    @Transactional
    public void updatePosition(PositionDto positionDto){
        Employee employee = employeeRepository.findById(positionDto.getEmployeeId()).orElseThrow(EmployeeNotFoundException::new);

        Position position = positionService.findByName(positionDto.getPositionName());

        employee.setPosition(position);
        employee.setDateAppointment(new Date().toInstant().toEpochMilli());
        employee.setDateDismissal(new Date().toInstant().toEpochMilli());

        employeeRepository.save(employee);
    }

    @Transactional
    public void add(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.dtoToEmployee(employeeDto);
        employee.setPosition(positionService.findByName(employeeDto.getPositionName()));
        employee.setCompany(companyService.findByName(employeeDto.getCompanyName()));
        employeeRepository.save(employee);
    }

    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }
}

package ru.pir.test.service.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.pir.test.service.dto.PositionDto;
import ru.pir.test.service.dto.PositionHistoryDto;
import ru.pir.test.service.exceptions.EmployeeNotFoundException;
import ru.pir.test.service.models.Employee;
import ru.pir.test.service.models.Position;
import ru.pir.test.service.models.kafka.PhaseEmployee;
import ru.pir.test.service.repositories.EmployeeRepository;
import ru.pir.test.service.repositories.PositionPagingRepository;
import ru.pir.test.service.repositories.PositionRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;

    private final PositionPagingRepository positionPagingRepository;
    private final EmployeeRepository employeeRepository;

    public void save(PhaseEmployee phaseEmployee, Employee employee){
        Position positions = new Position();

        positions.setEmployee(employee);
        positions.setPositionId(phaseEmployee.getPositionId());
        positions.setDateAppointment(phaseEmployee.getDateAppointment());
        positionRepository.save(positions);
    }

    @Transactional
    public PositionHistoryDto getEmployeeId(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        List<Position> positions = positionRepository.findByEmployee(employee);

        PositionHistoryDto positionHistoryDto = new PositionHistoryDto();
        positionHistoryDto.setEmployeeId(employee.getEmployeeId());

        List<PositionDto> positionsDto = new ArrayList<>();
        positions.forEach(position -> {
            PositionDto positionDto = new PositionDto();
            positionDto.setPositionId(position.getPositionId());
            positionDto.setDateAppointment(new Date(position.getDateAppointment()));
            if (position.getDateDismissal() != null) {
                positionDto.setDateDismissal(new Date(position.getDateDismissal()));
            }
            positionsDto.add(positionDto);
        });


        positionHistoryDto.setPositions(positionsDto);

        return positionHistoryDto;
    }


    public List<PositionHistoryDto> fetch(Pageable pageable) {
        Page<Employee> employees = positionPagingRepository.findAll(pageable);
        List<PositionHistoryDto> positionHistory = new ArrayList<>();
        employees.forEach(employee -> positionHistory.add(getEmployeeId(employee.getId())));
        return positionHistory;
    }

}

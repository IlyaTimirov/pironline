package ru.pir.test.service.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pir.test.kafka.models.Payload;
import ru.pir.test.service.exceptions.EmployeeNotFoundException;
import ru.pir.test.service.exceptions.PositionNotFoundException;
import ru.pir.test.service.models.Employee;
import ru.pir.test.service.models.Position;
import ru.pir.test.service.models.kafka.PhaseEmployee;
import ru.pir.test.service.repositories.EmployeeRepository;
import ru.pir.test.service.repositories.PositionRepository;
import ru.pir.test.service.utils.EmployeeMapper;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;

    private final EmployeeMapper employeeMapper;
    private final PositionService positionService;

    @Transactional
    public void updateAndSave(Payload<PhaseEmployee> employeePayload) {
        PhaseEmployee phaseEmployee = employeePayload.getAfter();
        Employee employee = employeeRepository.findByEmployeeId(phaseEmployee.getEmployeeId()).orElseThrow(EmployeeNotFoundException::new);

        Position position = positionRepository.findByEmployeeAndDateDismissalIsNull(employee).orElseThrow(PositionNotFoundException::new);
        position.setDateDismissal(phaseEmployee.getDateDismissal());
        positionRepository.save(position);
        positionService.save(phaseEmployee, employee);

    }

    @Transactional
    public void save(Payload<PhaseEmployee> employeePayload) {
        PhaseEmployee phaseEmployee = employeePayload.getAfter();
        Employee employee = employeeRepository.save(employeeMapper.phaseToEmployee(phaseEmployee));
        positionService.save(phaseEmployee, employee);
    }

}

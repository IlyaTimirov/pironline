package ru.api.pir.api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.api.pir.api.dto.EmployeeUpdateDto;
import ru.api.pir.api.exceptions.PositionNotFoundException;
import ru.api.pir.api.models.Position;
import ru.api.pir.api.repositories.PositionRepository;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;

    public Position findByName(String name) {
        return positionRepository.findByName(name).orElseThrow(PositionNotFoundException::new);
    }

}

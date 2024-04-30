package ru.pir.test.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.pir.test.service.models.Employee;
import ru.pir.test.service.models.Position;

import java.util.List;
import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    List<Position> findByEmployee(Employee employee);

    Optional<Position> findByEmployeeAndDateDismissalIsNull(Employee employee);
}

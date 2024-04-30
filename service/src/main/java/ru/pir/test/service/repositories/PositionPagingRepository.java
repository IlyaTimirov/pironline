package ru.pir.test.service.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.pir.test.service.models.Employee;
import ru.pir.test.service.models.Position;

import java.util.List;

@Repository
public interface PositionPagingRepository extends PagingAndSortingRepository<Employee, Long> {
    Page<Employee> findAll(Pageable pageable);
}

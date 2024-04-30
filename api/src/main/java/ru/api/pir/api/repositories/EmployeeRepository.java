package ru.api.pir.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.api.pir.api.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

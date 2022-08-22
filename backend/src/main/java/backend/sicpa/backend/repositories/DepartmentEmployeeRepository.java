package backend.sicpa.backend.repositories;

import backend.sicpa.backend.entities.DepartmentEmployee;
import backend.sicpa.backend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentEmployeeRepository extends JpaRepository<DepartmentEmployee, Integer> {

    Optional<DepartmentEmployee> findFirstByEmployee(Employee employee);
}

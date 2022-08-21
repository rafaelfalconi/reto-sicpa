package backend.sicpa.backend.repositories;

import backend.sicpa.backend.entities.DepartmentEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentEmployeeRepository extends JpaRepository<DepartmentEmployee,Integer> {
}

package backend.sicpa.backend.services;

import backend.sicpa.backend.entities.Department;
import backend.sicpa.backend.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> findAllDepartment() {
        return this.departmentRepository.findAll();
    }
}

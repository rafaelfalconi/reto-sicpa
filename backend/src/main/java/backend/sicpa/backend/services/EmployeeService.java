package backend.sicpa.backend.services;

import backend.sicpa.backend.entities.Employee;
import backend.sicpa.backend.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees() {
        return this.employeeRepository.findAll();
    }
}

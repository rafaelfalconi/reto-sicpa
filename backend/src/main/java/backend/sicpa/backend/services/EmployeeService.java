package backend.sicpa.backend.services;

import backend.sicpa.backend.dtos.EmployeeDto;
import backend.sicpa.backend.entities.Department;
import backend.sicpa.backend.entities.DepartmentEmployee;
import backend.sicpa.backend.entities.Employee;
import backend.sicpa.backend.exceptions.IncorrectDataException;
import backend.sicpa.backend.exceptions.NotFoundException;
import backend.sicpa.backend.repositories.DepartmentEmployeeRepository;
import backend.sicpa.backend.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;
    private final DepartmentEmployeeRepository departmentEmployeeRepository;

    public List<Employee> findAllEmployees() {
        return this.employeeRepository.findAll();
    }

    public void create(EmployeeDto employeeDto) {
        Department department = this.departmentService.getDeparmentById(employeeDto.getDepartment().getId());
        try {
            LocalDateTime now = LocalDateTime.now();
            Employee employee = this.employeeRepository.save(Employee.builder()
                    .name(employeeDto.getName())
                    .surname(employeeDto.getSurname())
                    .status(employeeDto.isStatus())
                    .email(employeeDto.getEmail())
                    .position(employeeDto.getPosition())
                    .age(employeeDto.getAge())
                    .createdBy("amdin")
                    .createdDate(now)
                    .build());
            this.departmentEmployeeRepository.save(DepartmentEmployee.builder()
                    .employee(employee)
                    .department(department)
                    .status(employeeDto.isStatus())
                    .createdBy("admin")
                    .createdDate(now)
                    .build());
        } catch (NullPointerException exception) {
            throw new IncorrectDataException("incorrect data send");
        }
    }

    public void edit(EmployeeDto employeeDto, int id) {
        try {
            Department department = this.departmentService.getDeparmentById(employeeDto.getDepartment().getId());
            LocalDateTime now = LocalDateTime.now();
            Optional<Employee> employeeOptional = this.employeeRepository.findById(id);
            if (employeeOptional.isEmpty()) throw new NotFoundException("\"employee does not exist \"");
            Employee employee = employeeOptional.get();
            employee.setName(employeeDto.getName());
            employee.setSurname(employeeDto.getSurname());
            employee.setEmail(employeeDto.getEmail());
            employee.setAge(employeeDto.getAge());
            employee.setPosition(employeeDto.getPosition());
            employee.setStatus(employeeDto.isStatus());
            employee.setModifiedBy("admin");
            employee.setModifiedDate(now);
            this.employeeRepository.save(employee);
            Optional<DepartmentEmployee> departmentEmployee = this.departmentEmployeeRepository.findFirstByEmployee(employee);
            if (departmentEmployee.isEmpty()) throw new NotFoundException("\"employee does not exist \"");
            DepartmentEmployee departmentEmployee1 = departmentEmployee.get();
            departmentEmployee1.setDepartment(department);
            departmentEmployee1.setModifiedBy("admin");
            departmentEmployee1.setModifiedDate(now);
            departmentEmployee1.setStatus(employeeDto.isStatus());
            departmentEmployee1.setStatus(employeeDto.isStatus());
            this.departmentEmployeeRepository.save(departmentEmployee1);
        } catch (NullPointerException exception) {
            throw new IncorrectDataException("incorrect data send");
        }
    }

    public EmployeeDto getById(int id) {
        Optional<Employee> employeeOptional = this.employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) throw new NotFoundException("\"employee does not exist \"");
        Employee employee = employeeOptional.get();
        Optional<DepartmentEmployee> departmentEmployee = this.departmentEmployeeRepository.findFirstByEmployee(employee);
        if (departmentEmployee.isEmpty()) throw new NotFoundException("\"employee does not exist \"");
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getName());
        employeeDto.setSurname(employee.getSurname());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDepartment(departmentEmployee.get().getDepartment());
        employeeDto.setAge(employee.getAge());
        employeeDto.setPosition(employee.getPosition());
        employeeDto.setStatus(employee.isStatus());
        employeeDto.setId(id);
        return employeeDto;
    }
}

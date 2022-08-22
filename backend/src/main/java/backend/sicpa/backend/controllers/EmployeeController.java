package backend.sicpa.backend.controllers;

import backend.sicpa.backend.dtos.EmployeeDto;
import backend.sicpa.backend.entities.Employee;
import backend.sicpa.backend.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(this.employeeService.findAllEmployees());
    }

    @PostMapping()
    public ResponseEntity<String> createEnterprise(@RequestBody EmployeeDto employeeDto) {
        this.employeeService.create(employeeDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"employee created\"");
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok(this.employeeService.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> editEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable int id) {
        this.employeeService.edit(employeeDto, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"employee edited\"");
    }
}

package backend.sicpa.backend.controllers;

import backend.sicpa.backend.dtos.DepartmentDto;
import backend.sicpa.backend.entities.Department;
import backend.sicpa.backend.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping()
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(this.departmentService.findAllDepartment());
    }

    @PostMapping()
    public ResponseEntity<String> createDepartment(@RequestBody DepartmentDto departmentDto){
        this.departmentService.createDepartment(departmentDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"department created\"");
    }
}

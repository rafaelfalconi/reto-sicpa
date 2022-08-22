package backend.sicpa.backend.controllers;

import backend.sicpa.backend.entities.Department;
import backend.sicpa.backend.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

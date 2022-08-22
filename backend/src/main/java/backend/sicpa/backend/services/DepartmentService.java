package backend.sicpa.backend.services;

import backend.sicpa.backend.dtos.DepartmentDto;
import backend.sicpa.backend.entities.Department;
import backend.sicpa.backend.entities.Enterprise;
import backend.sicpa.backend.exceptions.IncorrectDataException;
import backend.sicpa.backend.repositories.DepartmentRepository;
import backend.sicpa.backend.repositories.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EnterpriseService enterpriseService;

    public List<Department> findAllDepartment() {
        return this.departmentRepository.findAll();
    }

    public void createDepartment(DepartmentDto departmentDto) {
        Enterprise enterprise = enterpriseService.getEnterpriseById(departmentDto.getEnterprise().getId());
        try {
            LocalDateTime now = LocalDateTime.now();
            this.departmentRepository.save(Department.builder()
                    .name(departmentDto.getName())
                    .createdBy("admin")
                    .phone(departmentDto.getPhone())
                    .description(departmentDto.getDescription())
                    .enterprise(enterprise)
                    .createdDate(now).build());
        } catch (NullPointerException exception) {
            throw new IncorrectDataException("incorrect data send");
        }

    }
}

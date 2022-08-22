package backend.sicpa.backend.services;

import backend.sicpa.backend.dtos.DepartmentDto;
import backend.sicpa.backend.entities.Department;
import backend.sicpa.backend.entities.Enterprise;
import backend.sicpa.backend.exceptions.IncorrectDataException;
import backend.sicpa.backend.exceptions.NotFoundException;
import backend.sicpa.backend.repositories.DepartmentRepository;
import backend.sicpa.backend.repositories.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EnterpriseService enterpriseService;

    public List<Department> findAllDepartment() {
        return this.departmentRepository.findAll();
    }

    public void create(DepartmentDto departmentDto) {
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

    public void edit(DepartmentDto departmentDto,int id){
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if (departmentOptional.isEmpty()) throw new NotFoundException("\"department does  not exist \"");
        Enterprise enterprise = enterpriseService.getEnterpriseById(departmentDto.getEnterprise().getId());
        try {
            LocalDateTime now = LocalDateTime.now();
            Department department= departmentOptional.get();
            department.setName(departmentDto.getName());
            department.setStatus(departmentDto.isStatus());
            department.setPhone(departmentDto.getPhone());
            department.setDescription(departmentDto.getDescription());
            department.setEnterprise(enterprise);
            department.setModifiedBy("admin");
            department.setModifiedDate(now);
            this.departmentRepository.save(department);
        } catch (NullPointerException exception) {
            throw new IncorrectDataException("incorrect data send");
        }
    }
}

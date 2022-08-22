package backend.sicpa.backend.dtos;

import backend.sicpa.backend.entities.Department;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private int id;
    private int age;
    private boolean status;
    private String email, position, surname,name;
    private Department department;
}

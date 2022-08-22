package backend.sicpa.backend.dtos;

import backend.sicpa.backend.entities.Enterprise;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

    private boolean status;

    private String description,name, phone;

    private Enterprise enterprise;
}

package backend.sicpa.backend.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseDto {

    private boolean status;

    private String address, name, phone;
}

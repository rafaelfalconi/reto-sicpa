package backend.sicpa.backend.services;

import backend.sicpa.backend.dtos.EnterpriseDto;
import backend.sicpa.backend.entities.Enterprise;
import backend.sicpa.backend.exceptions.IncorrectDataException;
import backend.sicpa.backend.repositories.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    public List<Enterprise> getEnterprises() {
        return this.enterpriseRepository.findAll();
    }

    public void create(EnterpriseDto enterpriseDto) {
        try {
            LocalDateTime now = LocalDateTime.now();
            this.enterpriseRepository.save(Enterprise.builder()
                    .name(enterpriseDto.getName())
                    .createdBy("admin")
                    .phone(enterpriseDto.getPhone())
                    .address(enterpriseDto.getAddress())
                    .status(enterpriseDto.isStatus())
                    .createdDate(now)
                    .build());
        } catch (NullPointerException nullPointerException) {
            throw new IncorrectDataException("incorrect data send");
        }
    }
}

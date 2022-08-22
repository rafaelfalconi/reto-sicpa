package backend.sicpa.backend.services;

import backend.sicpa.backend.dtos.EnterpriseDto;
import backend.sicpa.backend.entities.Enterprise;
import backend.sicpa.backend.exceptions.IncorrectDataException;
import backend.sicpa.backend.exceptions.NotFoundException;
import backend.sicpa.backend.repositories.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

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

    public void edit(EnterpriseDto enterpriseDto, int id) {
        Optional<Enterprise> enterpriseOptional = this.enterpriseRepository.findById(id);
        if (enterpriseOptional.isEmpty()) throw new NotFoundException("\"enterprise not exist \"");
        Enterprise enterprise = enterpriseOptional.get();
        LocalDateTime now = LocalDateTime.now();
        enterprise.setName(enterpriseDto.getName());
        enterprise.setStatus(enterpriseDto.isStatus());
        enterprise.setPhone(enterpriseDto.getPhone());
        enterprise.setAddress(enterpriseDto.getAddress());
        enterprise.setModifiedDate(now);
        enterprise.setModifiedBy("admin");
        this.enterpriseRepository.save(enterprise);

    }
}

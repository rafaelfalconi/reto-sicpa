package backend.sicpa.backend.services;

import backend.sicpa.backend.entities.Enterprise;
import backend.sicpa.backend.repositories.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    public List<Enterprise> getEnterprises() {

        return this.enterpriseRepository.findAll();

    }
}

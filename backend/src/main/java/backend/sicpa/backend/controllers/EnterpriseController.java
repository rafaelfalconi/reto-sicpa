package backend.sicpa.backend.controllers;


import backend.sicpa.backend.entities.Enterprise;
import backend.sicpa.backend.services.EnterpriseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/enterprises")
public class EnterpriseController {

    private final EnterpriseService enterpriseService;

    @GetMapping()
    public ResponseEntity<List<Enterprise>> getAllEnterprise() {
        return ResponseEntity.ok(this.enterpriseService.getEnterprises());
    }
}

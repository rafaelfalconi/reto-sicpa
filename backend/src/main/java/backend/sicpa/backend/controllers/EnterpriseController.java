package backend.sicpa.backend.controllers;


import backend.sicpa.backend.dtos.EnterpriseDto;
import backend.sicpa.backend.entities.Enterprise;
import backend.sicpa.backend.services.EnterpriseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity<String> createEnterprise(@RequestBody EnterpriseDto enterpriseDto) {
        this.enterpriseService.create(enterpriseDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"enterprise created\"");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editEnterprises(@RequestBody EnterpriseDto enterpriseDto, @PathVariable int id) {
        this.enterpriseService.edit(enterpriseDto, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("\"enterprise edited\"");
    }
}

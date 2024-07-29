package br.com.fiap.parking_control.dominio.parquimetro.controller;

import br.com.fiap.parking_control.dominio.parquimetro.dto.ParquimetroDTO;
import br.com.fiap.parking_control.dominio.parquimetro.service.ParquimetroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parquimetros")
public class ParquimetroController {

    private final ParquimetroService parquimetroService;

    @Autowired
    public ParquimetroController(ParquimetroService parquimetroService) {
        this.parquimetroService = parquimetroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParquimetroDTO> findById(@PathVariable Long id) {
        ParquimetroDTO parquimetroDTO = parquimetroService.findById(id);
        return ResponseEntity.ok(parquimetroDTO);
    }

    @PostMapping
    public ResponseEntity<ParquimetroDTO> save(@Valid @RequestBody ParquimetroDTO parquimetroDTO) {
        ParquimetroDTO savedParquimetro = parquimetroService.save(parquimetroDTO);
        return new ResponseEntity<>(savedParquimetro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParquimetroDTO> update(@PathVariable Long id, @RequestBody ParquimetroDTO parquimetroDTO) {
        ParquimetroDTO updatedParquimetro = parquimetroService.update(id, parquimetroDTO);
        return ResponseEntity.ok(updatedParquimetro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        parquimetroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

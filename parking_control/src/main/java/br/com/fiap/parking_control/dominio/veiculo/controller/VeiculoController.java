package br.com.fiap.parking_control.dominio.veiculo.controller;


import br.com.fiap.parking_control.dominio.veiculo.dto.VeiculoDTO;
import br.com.fiap.parking_control.dominio.veiculo.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<Page<VeiculoDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "placa") Pageable pageable) {
        Page<VeiculoDTO> veiculoDTO = veiculoService.findAll(pageable);
        return ResponseEntity.ok(veiculoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {
        VeiculoDTO veiculoDTO = veiculoService.findById(id);
        return ResponseEntity.ok(veiculoDTO);
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> save(@Valid @RequestBody VeiculoDTO veiculoDTO) {
        VeiculoDTO savedVeiculo = veiculoService.save(veiculoDTO);
        return new ResponseEntity<>(savedVeiculo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @RequestBody VeiculoDTO veiculoDTO) {
        VeiculoDTO updatedVeiculo = veiculoService.update(id, veiculoDTO);
        return ResponseEntity.ok(updatedVeiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        veiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

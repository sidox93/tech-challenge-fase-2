package br.com.fiap.parking_control.dominio.credito.controller;

import br.com.fiap.parking_control.dominio.endereco.dto.EnderecoDTO;
import br.com.fiap.parking_control.dominio.endereco.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creditos")
public class CreditoController {

    private final EnderecoService enderecoService;

    @Autowired
    public CreditoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id){
        EnderecoDTO clienteDTO = enderecoService.findById(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> save(@Valid @RequestBody EnderecoDTO clienteDTO){
        EnderecoDTO savedCliente = enderecoService.save(clienteDTO);
        return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable Long id, @RequestBody EnderecoDTO clienteDTO){
        EnderecoDTO updateCliente = enderecoService.update(id, clienteDTO);
        return ResponseEntity.ok(updateCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package br.com.fiap.parking_control.dominio.endereco.controller;

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
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<Page<EnderecoDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "cep") Pageable pageable){
        Page<EnderecoDTO> clientesDTO = enderecoService.findAll(pageable);
        return ResponseEntity.ok(clientesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id){
        EnderecoDTO clienteDTO = enderecoService.findById(id);
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> save(@Valid @RequestBody EnderecoDTO enderecoDTO){
        EnderecoDTO savedEndereco = enderecoService.save(enderecoDTO);
        return new ResponseEntity<>(savedEndereco, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO){
        EnderecoDTO updateEndereco = enderecoService.update(id, enderecoDTO);
        return ResponseEntity.ok(updateEndereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

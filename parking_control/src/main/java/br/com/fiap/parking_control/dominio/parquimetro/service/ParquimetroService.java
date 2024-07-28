package br.com.fiap.parking_control.dominio.parquimetro.service;

import br.com.fiap.parking_control.dominio.parquimetro.dto.ParquimetroDTO;
import br.com.fiap.parking_control.dominio.parquimetro.entities.Parquimetro;
import br.com.fiap.parking_control.dominio.parquimetro.repository.IParquimetroRepository;
import br.com.fiap.parking_control.exception.ControllerNotFundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ParquimetroService {

    @Autowired
    private IParquimetroRepository iParquimetroRepository;

    @Autowired
    public ParquimetroService(IParquimetroRepository iParquimetroRepository) {
        this.iParquimetroRepository = iParquimetroRepository;
    }

    public Page<ParquimetroDTO> findAll(Pageable pageable) {
        Page<Parquimetro> parquimetros = iParquimetroRepository.findAll(pageable);
        return parquimetros.map(this::toParquimetroDTO);
    }

    public ParquimetroDTO findById(Long id) {
        Parquimetro parquimetro = iParquimetroRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFundException("Parquimetro não encontrado"));
        return toParquimetroDTO(parquimetro);
    }

    public ParquimetroDTO save(ParquimetroDTO parquimetroDTO) {
        Parquimetro parquimetro = toParquimetro(parquimetroDTO);
        parquimetro = iParquimetroRepository.save(parquimetro);
        return toParquimetroDTO(parquimetro);
    }

    public ParquimetroDTO update(Long id, ParquimetroDTO parquimetroDTO) {
        try {
            Parquimetro parquimetro = iParquimetroRepository.getReferenceById(id);

            parquimetro.setDataInicio(parquimetroDTO.dataInicio());
            parquimetro.setDataInicio(parquimetroDTO.dataFim());

            parquimetro = iParquimetroRepository.save(parquimetro);

            return toParquimetroDTO(parquimetro);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFundException("Parquimetro não encontrado");
        }
    }

    public void delete(Long id) {
        iParquimetroRepository.deleteById(id);
    }

    private ParquimetroDTO toParquimetroDTO(Parquimetro parquimetro) {
        return new ParquimetroDTO(
                parquimetro.getId(),
                parquimetro.getDataInicio(),
                parquimetro.getDataFim(),
                parquimetro.getEndereco()
        );
    }

    private Parquimetro toParquimetro(ParquimetroDTO parquimetroDTO) {
        return new Parquimetro(
                parquimetroDTO.id(),
                parquimetroDTO.dataInicio(),
                parquimetroDTO.dataFim(),
                parquimetroDTO.endereco()
        );
    }
}

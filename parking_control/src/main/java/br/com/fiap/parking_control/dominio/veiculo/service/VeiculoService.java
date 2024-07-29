package br.com.fiap.parking_control.dominio.veiculo.service;

import br.com.fiap.parking_control.dominio.veiculo.dto.VeiculoDTO;
import br.com.fiap.parking_control.dominio.veiculo.entities.Veiculo;
import br.com.fiap.parking_control.dominio.veiculo.repository.IVeiculoRepository;
import br.com.fiap.parking_control.exception.ControllerNotFundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    @Autowired
    private IVeiculoRepository iVeiculoRepository;

    @Autowired
    public VeiculoService(IVeiculoRepository iVeiculoRepository) {
        this.iVeiculoRepository = iVeiculoRepository;
    }

    public Page<VeiculoDTO> findAll(Pageable pageable) {
        Page<Veiculo> veiculos = iVeiculoRepository.findAll(pageable);
        return veiculos.map(this::toVeiculoDTO);
    }

    public VeiculoDTO findById(Long id) {
        Veiculo veiculo = iVeiculoRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFundException("veiculo não encontrada"));
        return toVeiculoDTO(veiculo);
    }

    public VeiculoDTO save(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = toVeiculo(veiculoDTO);
        veiculo = iVeiculoRepository.save(veiculo);
        return toVeiculoDTO(veiculo);
    }

    public VeiculoDTO update(Long id, VeiculoDTO veiculoDTO) {
        try {
            Veiculo veiculo = iVeiculoRepository.getReferenceById(id);

            veiculo.setPlaca(veiculoDTO.placa());
            veiculo.setMarca(veiculoDTO.marca());
            veiculo.setModelo(veiculoDTO.modelo());

            veiculo = iVeiculoRepository.save(veiculo);

            return toVeiculoDTO(veiculo);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFundException("veiculo não encontrado");
        }
    }

    public void delete(Long id) {
        iVeiculoRepository.deleteById(id);
    }

    private VeiculoDTO toVeiculoDTO(Veiculo veiculo) {
        return new VeiculoDTO(
                veiculo.getId(),
                veiculo.getPlaca(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getCliente()
        );
    }

    private Veiculo toVeiculo(VeiculoDTO veiculoDTO) {
        return new Veiculo(
                veiculoDTO.id(),
                veiculoDTO.placa(),
                veiculoDTO.marca(),
                veiculoDTO.modelo(),
                veiculoDTO.cliente()
        );
    }
}

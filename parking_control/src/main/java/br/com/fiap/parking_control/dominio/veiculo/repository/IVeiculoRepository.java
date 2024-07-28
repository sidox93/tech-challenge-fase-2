package br.com.fiap.parking_control.dominio.veiculo.repository;

import br.com.fiap.parking_control.dominio.veiculo.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVeiculoRepository extends JpaRepository<Veiculo, Long> {
}

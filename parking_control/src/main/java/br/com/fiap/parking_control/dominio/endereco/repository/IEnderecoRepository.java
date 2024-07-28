package br.com.fiap.parking_control.dominio.endereco.repository;


import br.com.fiap.parking_control.dominio.endereco.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnderecoRepository extends JpaRepository<Endereco, Long> {
}

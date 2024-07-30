package br.com.fiap.parking_control.dominio.parquimetro.entities.endereco.repoditory;


import br.com.fiap.parking_control.dominio.parquimetro.entities.endereco.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnderecoRepository extends JpaRepository<Endereco, Long> {
}

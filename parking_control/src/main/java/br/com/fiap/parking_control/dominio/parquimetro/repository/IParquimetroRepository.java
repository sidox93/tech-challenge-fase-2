package br.com.fiap.parking_control.dominio.parquimetro.repository;

import br.com.fiap.parking_control.dominio.parquimetro.entities.Parquimetro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParquimetroRepository extends JpaRepository<Parquimetro, Long> {
}

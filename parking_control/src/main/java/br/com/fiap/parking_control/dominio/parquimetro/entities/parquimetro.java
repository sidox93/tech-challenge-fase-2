package br.com.fiap.parking_control.dominio.parquimetro.entities;

import br.com.fiap.parking_control.dominio.endereco.entities.Endereco;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

public class parquimetro {

    @Id
    @Column(name = "ID_PARQUIMETRO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "DT_INICIO",length = 50, nullable = false)
    private LocalDateTime dataInicio = LocalDateTime.now();

    @NotNull
    @Column(name = "DT_FIM",length = 50, nullable = false)
    private LocalDateTime dataFim;

    private Endereco endereco;
}

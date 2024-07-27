package br.com.fiap.parking_control.dominio.veiculo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;

public class Veiculo {

    @Id
    @Column(name = "ID_VEICULO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "NR_PLACA",length = 15, nullable = false)
    private String placa;

    @NotNull
    @Column(name = "DS_MARCA",length = 50, nullable = false)
    private String marca;

    @NotNull
    @Column(name = "DS_MODELO",length = 50, nullable = false)
    private String modelo;

}

package br.com.fiap.parking_control.dominio.credito.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="TB_CREDITO")
public class Credito {

    @Id
    @Column(name = "ID_CREDITO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "VL_HORA",length = 60, nullable = false)
    private double valorHora;

    @NotNull
    @Column(name = "QT_CREDITO",length = 60, nullable = false)
    private String quantidadeCredito;

}

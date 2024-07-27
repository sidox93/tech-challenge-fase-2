package br.com.fiap.parking_control.dominio.cliente.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;

public class Cliente {

    @Id
    @Column(name = "ID_CLIENTE", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "EM_EMAIL",length = 50, nullable = false)
    private String email;

    @NotNull
    @Column(name = "NR_TELEFONE",length = 50, nullable = false)
    private String telefone;

}

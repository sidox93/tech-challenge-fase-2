package br.com.fiap.parking_control.dominio.parquimetro.entities;


import br.com.fiap.parking_control.dominio.parquimetro.entities.endereco.entities.Endereco;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name="TB_PARQUIMETRO")
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

    @ManyToOne
    @JoinColumn(name = "endereco_id_endereco")
    private Endereco endereco;

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

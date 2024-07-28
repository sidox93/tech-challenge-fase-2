package br.com.fiap.parking_control.dominio.parquimetro.entities;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="TB_PARQUIMETRO")
public class Parquimetro {

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

    public Parquimetro() {
    }

    public Parquimetro(Long id, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parquimetro that = (Parquimetro) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Parquimetro{" +
                "id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                '}';
    }
}

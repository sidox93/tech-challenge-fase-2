package br.com.fiap.parking_control.dominio.parquimetro.dto;

import br.com.fiap.parking_control.dominio.endereco.entities.Endereco;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ParquimetroDTO(
        Long id,

        @NotNull(message = "A data de inicio não pode estar em branco.")
        LocalDateTime dataInicio,

        @NotNull(message = "A data fim não pode estar em branco.")
        LocalDateTime dataFim,

        Endereco endereco

) {
}
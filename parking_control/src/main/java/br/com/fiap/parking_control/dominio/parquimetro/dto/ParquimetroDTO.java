package br.com.fiap.parking_control.dominio.parquimetro.dto;

import br.com.fiap.parking_control.dominio.endereco.entities.Endereco;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record ParquimetroDTO(
        Long id,

        @NotBlank(message = "A data de inicio não pode estar em branco.")
        LocalDateTime dataInicio,

        @NotBlank(message = "A data fim não pode estar em branco.")
        LocalDateTime dataFim,

        Endereco endereco

) {
}
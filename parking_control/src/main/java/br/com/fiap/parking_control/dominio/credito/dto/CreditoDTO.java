package br.com.fiap.parking_control.dominio.credito.dto;

import jakarta.validation.constraints.NotBlank;

public record CreditoDTO(

        Long id,

        @NotBlank(message = "O Valor Hora não pode estar em branco")
        String valorHora,

        @NotBlank(message = "A quantidade credito da estado não pode estar em branco")
        String quantidadeCredito

) {
}

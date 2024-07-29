package br.com.fiap.parking_control.dominio.veiculo.dto;

import br.com.fiap.parking_control.dominio.cliente.entities.Cliente;
import jakarta.validation.constraints.NotBlank;

public record VeiculoDTO(
        Long id,

        @NotBlank(message = "O numero da placa não pode estar em branco.")
        String placa,

        @NotBlank(message = "A marca não pode estar em branco.")
        String marca,

        @NotBlank(message = "O modelo não pode estar em branco.")
        String modelo,

        Cliente cliente

) {
}
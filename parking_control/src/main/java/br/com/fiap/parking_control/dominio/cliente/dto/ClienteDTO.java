package br.com.fiap.parking_control.dominio.cliente.dto;

import br.com.fiap.parking_control.dominio.endereco.entities.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record ClienteDTO(
        Long id,

        @NotBlank(message = "O nome não pode estar em branco.")
        String nome,

        @CPF(message = "O CPF é inválido.")
        String cpf,

        @Email(message = "O E-mail é inválido.")
        @NotBlank(message = "O E-mail não pode estar em branco.")
        String email,

        @NotBlank(message = "O telefone não pode estar em branco.")
        String telefone,

        Endereco endereco

) {
}
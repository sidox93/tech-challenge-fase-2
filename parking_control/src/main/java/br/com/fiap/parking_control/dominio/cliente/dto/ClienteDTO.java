package br.com.fiap.parking_control.dominio.cliente.dto;

import br.com.fiap.parking_control.dominio.endereco.entities.Endereco;
import br.com.fiap.parking_control.dominio.veiculo.entities.Veiculo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record ClienteDTO(
        Long id,

        @NotBlank(message = "O nome não pode estar em branco.")
        String nome,

        @Email(message = "O E-mail é inválido.")
        @NotBlank(message = "O E-mail não pode estar em branco.")
        String email,

        @CPF(message = "O CPF é inválido.")
        String cpf,

        @NotBlank(message = "O telefone não pode estar em branco.")
        String telefone,

        List<Veiculo> veiculos,

        List<Endereco> enderecos

) {
}
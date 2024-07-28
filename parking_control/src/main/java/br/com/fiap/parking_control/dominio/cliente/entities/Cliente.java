package br.com.fiap.parking_control.dominio.cliente.entities;

import br.com.fiap.parking_control.dominio.endereco.entities.Endereco;
import br.com.fiap.parking_control.dominio.veiculo.entities.Veiculo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="TB_CLIENTE")
public class Cliente {

    @Id
    @Column(name = "ID_CLIENTE", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @jakarta.validation.constraints.NotNull
    @Column(name = "NM_NOME",length = 60, nullable = false)
    private String nome;

    @jakarta.validation.constraints.NotNull
    @Column(name = "NR_CPF",length = 11, nullable = false)
    private String cpf;

    @NotNull
    @Column(name = "EM_EMAIL",length = 50, nullable = false)
    private String email;

    @NotNull
    @Column(name = "NR_TELEFONE",length = 50, nullable = false)
    private String telefone;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Veiculo> veiculos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente() {}

    public Cliente(Long id, String nome, String cpf, String email, String telefone, List<Veiculo> veiculos, List<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.veiculos = veiculos;
        this.enderecos = enderecos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", veiculos=" + veiculos +
                ", enderecos=" + enderecos +
                '}';
    }
}

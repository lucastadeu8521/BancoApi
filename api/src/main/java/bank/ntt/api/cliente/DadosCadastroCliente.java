package bank.ntt.api.cliente;

import bank.ntt.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(
        @NotBlank String nome,
        @Email String email,
        @NotBlank String telefone,
        @NotBlank String cpf,
        @NotNull @Valid DadosEndereco endereco,
        @NotNull String login,
        @NotNull String  senha
){}

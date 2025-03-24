package bank.ntt.api.conta;

import bank.ntt.api.cliente.Cliente;
import bank.ntt.api.cliente.DadosCadastroCliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroConta(
        @NotBlank String login,
        @NotBlank String senha,
        @NotNull DadosCadastroCliente cliente
){}


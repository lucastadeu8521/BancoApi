package bank.ntt.api.cliente;

import bank.ntt.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}

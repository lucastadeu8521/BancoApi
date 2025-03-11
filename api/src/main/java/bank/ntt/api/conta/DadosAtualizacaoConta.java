package bank.ntt.api.conta;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConta(
        @NotNull Long id,
        double valor,
        boolean ativo,
        double saldo) {
}

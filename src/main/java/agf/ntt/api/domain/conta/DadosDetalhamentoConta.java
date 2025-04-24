package agf.ntt.api.domain.conta;

import java.math.BigDecimal;

public record DadosDetalhamentoConta(Long contaID, Long clienteID, String login, BigDecimal saldo) {

    public DadosDetalhamentoConta(Conta conta){
        this(conta.getContaID(),conta.getClienteID(),conta.getLogin(),conta.getSaldo());
    }
}

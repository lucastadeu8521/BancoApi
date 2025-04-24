package agf.ntt.api.domain.conta;

import java.math.BigDecimal;

public record DadosListagemConta(Long clienteID, Long contaID, String login, BigDecimal saldo) {
    public DadosListagemConta(Conta conta){
        this(conta.getContaID(), conta.getClienteID(), conta.getLogin(), conta.getSaldo());
    }
}

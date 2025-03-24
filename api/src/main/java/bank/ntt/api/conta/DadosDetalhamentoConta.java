package bank.ntt.api.conta;

import bank.ntt.api.cliente.Cliente;
import bank.ntt.api.cliente.DadosDetalhamentoCliente;

public record DadosDetalhamentoConta(Long id, String login, String senha,double saldo, Cliente cliente) {

    public DadosDetalhamentoConta(Conta conta){
        this(conta.getId(), conta.getLogin(), conta.getSenha(), conta.getSaldo(), conta.getCliente());
    }
}

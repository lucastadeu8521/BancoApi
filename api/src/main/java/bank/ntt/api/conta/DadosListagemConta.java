package bank.ntt.api.conta;

import bank.ntt.api.cliente.Cliente;

public record DadosListagemConta(Long id, double saldo) {

    public DadosListagemConta (Cliente cliente){
        this(cliente.getId(), cliente.getSaldo());
    }
}





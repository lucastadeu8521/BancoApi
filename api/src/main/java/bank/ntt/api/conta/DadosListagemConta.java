package bank.ntt.api.conta;

import bank.ntt.api.cliente.Cliente;

public record DadosListagemConta(Long id, double saldo, Cliente cliente) {

    public DadosListagemConta (Conta conta){
        this(conta.getId(), conta.getSaldo(), conta.getCliente());
    }
}





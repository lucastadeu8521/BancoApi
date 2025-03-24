package bank.ntt.api.cliente;

import bank.ntt.api.endereco.Endereco;

public record DadosDetalhamentoCliente(Long id, String nome, String email, Endereco endereco,String cpf, String telefone) {

    public DadosDetalhamentoCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(),cliente.getEmail(),cliente.getEndereco(),cliente.getCpf(), cliente.getTelefone());
    }
}

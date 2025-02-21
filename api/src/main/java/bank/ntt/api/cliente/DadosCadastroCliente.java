package bank.ntt.api.cliente;

import bank.ntt.api.endereco.DadosEndereco;

public record DadosCadastroCliente(String nome, String email, String cpf, DadosEndereco endereco) {}

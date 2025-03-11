package bank.ntt.api.cliente;

public record DadosListagemCliente(Long id, String nome, String email, String login, double saldo) {

    public DadosListagemCliente (Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getLogin(), cliente.getSaldo());
    }
}

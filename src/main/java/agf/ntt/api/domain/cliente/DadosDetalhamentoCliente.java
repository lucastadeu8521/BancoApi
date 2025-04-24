package agf.ntt.api.domain.cliente;

public record DadosDetalhamentoCliente(Long clienteID, String nome, String email, String telefone, String cpf) {

    public DadosDetalhamentoCliente(Cliente cliente){
        this(cliente.getClienteID(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getCpf());
    }
}

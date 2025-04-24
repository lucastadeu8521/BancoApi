package agf.ntt.api.domain.cliente;

public record DadosListagemCliente(String nome, String email, String telefone, String cpf) {
    public DadosListagemCliente(Cliente cliente){
        this(cliente.getNome(),cliente.getEmail(), cliente.getTelefone(), cliente.getCpf());
    }
}

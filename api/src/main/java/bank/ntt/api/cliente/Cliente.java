package bank.ntt.api.cliente;

import bank.ntt.api.conta.DadosAtualizacaoConta;
import bank.ntt.api.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String login;
    private String senha;
    private double saldo;

    @Embedded
    private Endereco endereco;

    private boolean ativo;


    public Cliente(DadosCadastroCliente dados) {
        this.ativo = true;
        this.saldo = 0;
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
        this.telefone = dados.telefone();
        this.login = dados.login();
        this.senha = dados.senha();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoCliente dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }

    public void saque(@Valid DadosAtualizacaoConta dados){
        if (dados.valor() >= this.saldo && dados.ativo()) {
            this.saldo = this.saldo - dados.valor();
        }
    }

    public void deposito(@Valid DadosAtualizacaoConta dados) {

        if (dados.valor() > 0 && dados.ativo()){
            this.saldo = this.saldo + dados.valor();
        }
    }
}

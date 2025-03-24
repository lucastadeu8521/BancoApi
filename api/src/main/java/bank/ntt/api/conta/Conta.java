package bank.ntt.api.conta;


import bank.ntt.api.cliente.Cliente;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "contas")
@Entity(name = "Conta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String senha;
    private double saldo;
    private boolean ativo;

    @Embedded
    private Cliente cliente;

    public Conta(DadosCadastroConta dados) {
        this.ativo = true;
        this.saldo = 0;
        this.login = dados.login();
        this.senha = dados.senha();
        this.cliente = new Cliente(dados.cliente());
    }
}

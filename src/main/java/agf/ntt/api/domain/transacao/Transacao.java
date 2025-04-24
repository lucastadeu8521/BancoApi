package agf.ntt.api.domain.transacao;

import agf.ntt.api.domain.conta.Conta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transacaoID;

    @ManyToOne
    @JoinColumn(name = "contaID")
    private Conta conta;
    private LocalDateTime dataTransacao;
    private String tipoTransacao;
    private BigDecimal value;
}

package agf.ntt.api.domain.conta;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SaqueRequest {
    private Long contaID;
    private BigDecimal valor;
}
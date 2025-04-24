package agf.ntt.api.domain.conta;

import jakarta.validation.Valid;

public record DadosCadastroConta(
        @Valid Long clienteID,
        @Valid String login,
        @Valid String senha) {
}

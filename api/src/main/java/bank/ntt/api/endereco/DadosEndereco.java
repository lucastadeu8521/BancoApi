package bank.ntt.api.endereco;

import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(
        @NotBlank String logradouro,
        @NotBlank String bairro,
        @NotBlank String cep,
        @NotBlank String cidade,
        @NotBlank String uf,
        @NotBlank String complemento,
        @NotBlank String numero) {

}

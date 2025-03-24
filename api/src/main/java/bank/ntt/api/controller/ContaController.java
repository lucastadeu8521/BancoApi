package bank.ntt.api.controller;


import bank.ntt.api.cliente.Cliente;
import bank.ntt.api.cliente.ClienteRepository;
import bank.ntt.api.cliente.DadosDetalhamentoCliente;
import bank.ntt.api.conta.Conta;
import bank.ntt.api.conta.ContaRepository;
import bank.ntt.api.conta.DadosCadastroConta;
import bank.ntt.api.conta.DadosDetalhamentoConta;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConta dados,  UriComponentsBuilder uriBuilder) {
        var conta = new Conta(dados);
        repository.save(conta);

        var uri = uriBuilder.path("/contas/{id}").buildAndExpand(conta.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoConta(conta));
    }

    // Add other CRUD endpoints
}

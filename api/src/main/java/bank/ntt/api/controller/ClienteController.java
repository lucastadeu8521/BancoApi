package bank.ntt.api.controller;


import bank.ntt.api.cliente.*;
import bank.ntt.api.conta.DadosAtualizacaoConta;
import bank.ntt.api.conta.DadosListagemConta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder) {
        var cliente = new Cliente(dados);
        repository.save(cliente);

        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemCliente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagination){

        var page = repository.findAllByAtivoTrue(pagination).map(DadosListagemCliente::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);
        cliente.excluir();

        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @PutMapping("/saque")
    @Transactional
    public ResponseEntity saque(@RequestBody @Valid DadosAtualizacaoConta dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.saque(dados);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/deposito")
    @Transactional
    public ResponseEntity deposito(@RequestBody @Valid DadosAtualizacaoConta dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.deposito(dados);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/saldo")
    public ResponseEntity <Page<DadosListagemConta>> saldo(@PageableDefault(size = 10, sort = {"saldo"}) Pageable pagination){

        var page = repository.findAllByAtivoTrue(pagination).map(DadosListagemConta::new);

        return ResponseEntity.ok(page);
    }
}



















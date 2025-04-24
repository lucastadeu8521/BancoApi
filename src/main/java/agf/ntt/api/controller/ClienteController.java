package agf.ntt.api.controller;

import agf.ntt.api.domain.cliente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriBuilder) {
        var cliente = new Cliente(dados);
        clienteRepository.save(cliente);

        var uri = uriBuilder.path("/clientes/{clienteID}").buildAndExpand(cliente.getClienteID()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCliente>> listarCliente(Pageable paginacao){
        var page = clienteRepository.findAllByAtivoTrue(paginacao).map(DadosListagemCliente::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarConta(@RequestBody @Valid DadosAtualizacaoCliente dados){
        var cliente = clienteRepository.getReferenceById(dados.clienteID());
        cliente.atualizaCliente(dados);

        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @DeleteMapping("/{clienteID}")
    @Transactional
    public ResponseEntity desativarCliente(@PathVariable Long clienteID){
        var cliente = clienteRepository.getReferenceById(clienteID);
        cliente.desativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{clienteID}")
    public ResponseEntity detalharCliente(@PathVariable Long clienteID){
        var cliente = clienteRepository.getReferenceById(clienteID);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }
}

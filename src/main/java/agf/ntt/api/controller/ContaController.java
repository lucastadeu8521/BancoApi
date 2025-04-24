package agf.ntt.api.controller;

import agf.ntt.api.domain.conta.*;
import agf.ntt.api.domain.transacao.Transacao;
import agf.ntt.api.domain.transacao.TransacaoRepository;
import agf.ntt.api.infra.carga.ContaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaService contaService;


    @PostMapping
    public ResponseEntity cadastrarConta(@RequestBody @Valid DadosCadastroConta dados, UriComponentsBuilder uriBuilder) {
        var conta = new Conta(dados);
        contaRepository.save(conta);

        var uri = uriBuilder.path("/contas/{contaID}").buildAndExpand(conta.getContaID()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoConta(conta));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemConta>> listarConta(Pageable paginacao) {
        var page = contaRepository.findAllByAtivoTrue(paginacao).map(DadosListagemConta::new);

        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{contaID}")
    @Transactional
    public ResponseEntity desativarConta(@PathVariable Long contaID) {
        var conta = contaRepository.getReferenceById(contaID);
        conta.desativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{contaID}")
    public ResponseEntity detalharConta(@PathVariable Long contaID) {
        var conta = contaRepository.getReferenceById(contaID);
        return ResponseEntity.ok(new DadosDetalhamentoConta(conta));
    }

    @PostMapping("/deposito")
    public ResponseEntity<String> depositar(@RequestBody DepositoRequest depositoRequest) {
        Optional<Conta> optionalConta = contaRepository.findById(depositoRequest.getContaID());

        if (optionalConta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada.");
        }

        Conta conta = optionalConta.get();
        BigDecimal valor = depositoRequest.getValor();

        if (valor != null && valor.compareTo(BigDecimal.ZERO) > 0) {
            conta.setSaldo(conta.getSaldo().add(valor));
            contaRepository.save(conta);

            Transacao transacao = new Transacao();
            transacao.setConta(conta);
            transacao.setDataTransacao(LocalDateTime.now());  // Current timestamp
            transacao.setTipoTransacao("DEPÓSITO");
            transacao.setValue(depositoRequest.getValor());

            transacaoRepository.save(transacao);

            return ResponseEntity.ok("Depósito realizado com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Valor inválido para depósito.");
        }
    }

    @PostMapping("/saque")
    public ResponseEntity<String> sacar(@RequestBody SaqueRequest saqueRequest) {
        Optional<Conta> optionalConta = contaRepository.findById(saqueRequest.getContaID());

        if (optionalConta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada.");
        }

        Conta conta = optionalConta.get();
        BigDecimal valor = saqueRequest.getValor();

        if (valor != null &&
                valor.compareTo(BigDecimal.ZERO) > 0 &&
                valor.compareTo(conta.getSaldo()) < 0) {

            conta.setSaldo(conta.getSaldo().subtract(valor));
            contaRepository.save(conta);

            Transacao transacao = new Transacao();
            transacao.setConta(conta);
            transacao.setDataTransacao(LocalDateTime.now());
            transacao.setTipoTransacao("SAQUE");
            transacao.setValue(saqueRequest.getValor());
            transacaoRepository.save(transacao);

            return ResponseEntity.ok("Saque realizado com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Valor inválido para saque.");
        }
    }

    @PostMapping("/importar")
    public ResponseEntity<?> uploadContaData(@RequestParam("file")MultipartFile file){
        this.contaService.saveContaToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message", "Dados das contas importados e salvos na base de dados"));
    }

    @GetMapping("/listaImports")
    public ResponseEntity<List<Conta>> getContas(){
        return new ResponseEntity<>(contaService.getContas(), HttpStatus.FOUND);
    }
}
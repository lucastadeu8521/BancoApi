package agf.ntt.api.controller;

import agf.ntt.api.domain.conta.Conta;
import agf.ntt.api.domain.conta.DadosAutenticacao;
import agf.ntt.api.infra.security.TokenService;
import agf.ntt.api.infra.security.DadosToken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){

        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Conta)authentication.getPrincipal());

        return ResponseEntity.ok(new DadosToken(tokenJWT));
    }
}

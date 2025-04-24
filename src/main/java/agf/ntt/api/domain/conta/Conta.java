package agf.ntt.api.domain.conta;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="contaID")
@Table(name = "contas")
@Entity(name = "Conta")
public class Conta implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contaID;
    private Long clienteID;
    private String login;
    private String senha;
    private BigDecimal saldo = BigDecimal.ZERO;
    private Boolean ativo;

    public Conta(DadosCadastroConta dados) {
        this.clienteID = dados.clienteID();
        this.login = dados.login();
        this.senha = dados.senha();
        this.ativo = true;
    }

    public void desativar() {
        this.ativo = false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}

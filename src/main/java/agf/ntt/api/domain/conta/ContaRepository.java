package agf.ntt.api.domain.conta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    Page<Conta> findAllByAtivoTrue(Pageable paginacao);
    UserDetails findByLogin(String login);
}

package dangelodavide.U2_W2_D4_Friday.repository;

import dangelodavide.U2_W2_D4_Friday.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DipendenteRepository extends JpaRepository<Dipendente, UUID> {
    boolean existsByUsername(String username);
}

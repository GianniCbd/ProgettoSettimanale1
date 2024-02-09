package epicode.progetto.DAO;

import epicode.progetto.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteDAO extends JpaRepository<Utente,Long> {
    List<Utente> findByNameStartingWithIgnoreCase(String partialname);

}

package epicode.progetto.DAO;

import epicode.progetto.Enum.TipoLocation;
import epicode.progetto.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationDAO extends JpaRepository<Location,Long> {


    @Query("SELECT l FROM Location l WHERE l.stato= 'LIBERA' AND l.tipo = :tipo AND l.edificio.citta = :citta ")
    public List<Location> trovaLocation(TipoLocation tipo, String citta);

}

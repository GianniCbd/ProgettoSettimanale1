package epicode.progetto.DAO;

import epicode.progetto.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationDAO extends JpaRepository<Location,Long> {

    @Query("SELECT l FROM Location l WHERE id=:locationId ")
    public List<Location> trovaLocation();

}

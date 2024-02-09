package epicode.progetto.DAO;

import epicode.progetto.Enum.StatoLocation;
import epicode.progetto.Enum.TipoLocation;
import epicode.progetto.entities.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class LocationService {

    @Autowired
    private LocationDAO locationDAO;

    public void saveLocation(Location newLocation) {
        locationDAO.save(newLocation);
        log.info("Location salvata correttamente");
    }
    public boolean LocationLibera(long locationId) throws ItemNotFoundException {
        Location location = findById(locationId);
        return location.getStato() == StatoLocation.LIBERA;
    }
    public Location findById(long locationId) throws ItemNotFoundException {
        return locationDAO.findById(locationId).orElseThrow(() -> new ItemNotFoundException(locationId));
    }

    public List<Location> trovaLocationDisponibili(TipoLocation tipo,String citta){
        try{
            locationDAO.trovaLocation(TipoLocation.OPEN_SPACE,"Cagliari");
            System.out.println("location "+ TipoLocation.OPEN_SPACE +" disponibile a " + citta.toUpperCase());
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
        return Collections.emptyList();
    }

}

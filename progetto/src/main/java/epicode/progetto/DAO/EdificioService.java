package epicode.progetto.DAO;

import epicode.progetto.entities.Edificio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EdificioService {

@Autowired
    private EdificioDAO edificioDAO;

public void saveEdificio(Edificio newEdificio){
    edificioDAO.save(newEdificio);
    log.info("Edificio salvato correttamente");
}
    public Edificio findById(long edificioId) throws ItemNotFoundException {
        return edificioDAO.findById(edificioId).orElseThrow(() -> new ItemNotFoundException(edificioId));
    }
}

package epicode.progetto.DAO;

import epicode.progetto.entities.Prenotazione;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrenotazioneService {
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;

    public void savePrenotazione(Prenotazione newPrenotazione){
        prenotazioneDAO.save(newPrenotazione);
        log.info("Prenotazione salvata correttamente");
    }
    public Prenotazione findById(long prenotazioneId) throws ItemNotFoundException {
        return prenotazioneDAO.findById(prenotazioneId).orElseThrow(() -> new ItemNotFoundException(prenotazioneId));
    }

}

package epicode.progetto;

import epicode.progetto.DAO.UtenteService;
import epicode.progetto.entities.Utente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProgettoApplicationTests {

	@Autowired
	private UtenteService utenteService;

	@Test
	public void testSaveUtente() {
		Utente utente = new Utente("username", "name", "email");
		utenteService.saveUtente(utente);
		Assertions.assertNotNull(utente.getId());
	}




}

package epicode.progetto;

import epicode.progetto.DAO.*;
import epicode.progetto.entities.Edificio;
import epicode.progetto.entities.Location;
import epicode.progetto.entities.Prenotazione;
import epicode.progetto.entities.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {
    @Autowired
    private Utente utente;
    @Autowired
    private Edificio edificio;
    @Autowired
    private Location location;
    @Autowired
    private Prenotazione prenotazione;
@Autowired
    LocationService locationService;
@Autowired
    EdificioService edificioService;
@Autowired
    UtenteService utenteService;
@Autowired
    PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ProgettoApplication.class);


//*********************************EDIFICI*************************************************
        Edificio attico = ctx.getBean("Attico", Edificio.class);
        Edificio mansarda = ctx.getBean("Mansarda", Edificio.class);
        Edificio Hotel = ctx.getBean("Hotel Gianni&Cabiddu", Edificio.class);
        System.out.println(attico);
        System.out.println(mansarda);
        System.out.println(Hotel);
        edificioService.saveEdificio(attico);
        edificioService.saveEdificio(mansarda);
        edificioService.saveEdificio(Hotel);
//********************************LOCATION************************************************
        Location location = ctx.getBean("locationUno", Location.class);
        Location locationDue = ctx.getBean("locationDue", Location.class);
        Location locationTre = ctx.getBean("locationTre", Location.class);

        System.out.println(location);
        System.out.println(locationDue);
        System.out.println(locationTre);
        locationService.saveLocation(location);
        locationService.saveLocation(locationDue);
        locationService.saveLocation(locationTre);

//"********************************UTENTE***********************************************"

        Utente utente = ctx.getBean("utente", Utente.class);
        Utente utenteDue = ctx.getBean("utenteDue", Utente.class);
        Utente utenteTre = ctx.getBean("utenteTre", Utente.class);

        System.out.println(utente);
        System.out.println(utenteDue);
        System.out.println(utenteTre);
        utenteService.saveUtente(utente);
        utenteService.saveUtente(utenteDue);
        utenteService.saveUtente(utenteTre);

//********************************PRENOTAZIONI************************************************

        Prenotazione prenotazioneUno = ctx.getBean("prenotazioneUno", Prenotazione.class);
        Prenotazione prenotazioneDue = ctx.getBean("prenotazioneDue", Prenotazione.class);
        Prenotazione prenotazioneTre = ctx.getBean("prenotazioneTre", Prenotazione.class);

        System.out.println(prenotazioneUno);
        System.out.println(prenotazioneDue);
        System.out.println(prenotazioneTre);
        prenotazioneService.savePrenotazione(prenotazioneUno);
        prenotazioneService.savePrenotazione(prenotazioneDue);
        prenotazioneService.savePrenotazione(prenotazioneTre);

        System.out.println("**********************FINDBYID**********************************");

        try {
            Utente fromDB = utenteService.findById(10);
            System.out.println(fromDB);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        try {
            Prenotazione fromDB = prenotazioneService.findById(1);
            System.out.println(fromDB);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        try {
            Edificio fromDB = edificioService.findById(1);
            System.out.println(fromDB);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        try {
            Location fromDB = locationService.findById(1);
            System.out.println(fromDB);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        System.out.println("********************StatoLocation*********************************");
        try {
            if (locationService.LocationLibera(3)) {
                System.out.println("La location è libera");
            } else {
                System.out.println("La location è occupata");
            }
        } catch (ItemNotFoundException e) {
            System.out.println("Location non trovata");
        }

    }
}


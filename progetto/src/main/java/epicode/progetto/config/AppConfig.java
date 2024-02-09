package epicode.progetto.config;

import com.github.javafaker.Faker;
import epicode.progetto.Enum.StatoLocation;
import epicode.progetto.Enum.TipoLocation;
import epicode.progetto.entities.Edificio;
import epicode.progetto.entities.Location;
import epicode.progetto.entities.Prenotazione;
import epicode.progetto.entities.Utente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;
import java.util.Locale;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    @Bean
    public Faker faker() {
        return new Faker(Locale.ITALY);
    }

    //**********UTENTI**********************
    @Bean(name = "utente")
    public Utente utenteUno(){
        return new Utente(faker().name().username(),faker().name().fullName(),faker().internet().emailAddress());
    }
    @Bean(name = "utenteDue")
    public Utente utenteDue(){
        return new Utente(faker().name().username(),faker().name().fullName(),faker().internet().emailAddress());
    }
    @Bean(name = "utenteTre")
    public Utente utenteTre(){
        return new Utente(faker().name().username(),faker().name().fullName(),faker().internet().emailAddress());
    }

    //************LOCATION********************
    @Bean(name = "locationUno")
    @Primary
    public Location postazioneUno(){
        return new Location(faker().random().nextLong(20L),"Indimenticabile",TipoLocation.PRIVATO,StatoLocation.LIBERA,faker().random().nextInt(1,10),attico());
    }
    @Bean(name = "locationDue")
    public Location postazioneDue(){
        return new Location(faker().random().nextLong(20L),"Affare",TipoLocation.OPEN_SPACE,StatoLocation.LIBERA,faker().random().nextInt(1,10),mansarda());
    }
    @Bean(name = "locationTre")
    public Location postazioneTre(){
        return new Location(faker().random().nextLong(20L),"JavaConvention",TipoLocation.OPEN_SPACE,StatoLocation.OCCUPATA,faker().random().nextInt(1,10),hotel());

    }

    //************PRENOTAZIONI********************

    @Bean(name = "prenotazioneUno")
    @Primary
    public Prenotazione prenotazioneUno(){
        return new Prenotazione(utenteUno(),postazioneUno(), LocalDate.now().plusDays(1));
    }
    @Bean(name = "prenotazioneDue")
    public Prenotazione prenotazioneDue(){
        return new Prenotazione(utenteDue(),postazioneDue(), LocalDate.now().plusDays(1));
    }
    @Bean(name = "prenotazioneTre")
    public Prenotazione prenotazioneTre(){
        return new Prenotazione(utenteTre(),postazioneTre(), LocalDate.now().plusDays(1));
    }

    //**********EDIFICI**********************
    @Bean(name = "Attico")
    @Primary
    public Edificio attico() {
        return new Edificio("Attico","Via Gramsci","Cagliari");
    }
    @Bean(name = "Mansarda")
    public Edificio mansarda() {
        return new Edificio("Mansarda","Via Paoli","Perugia");
    }
    @Bean(name = "Hotel Gianni&Cabiddu")
    public Edificio hotel() {
        return new Edificio("Hotel", "Via NicolaFabrizi", "Pescara");
    }


}
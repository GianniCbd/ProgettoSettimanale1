package epicode.progetto.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "prenotazione")
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    private LocalDate data;

    public Prenotazione(Utente utente, Location location, LocalDate data) {
        this.utente = utente;
        this.location = location;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Prenotazione -> " +
                "utente=" + utente +
                ", location=" + location +
                ", data=" + data +
                '}';
    }

}

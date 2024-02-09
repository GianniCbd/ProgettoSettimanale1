package epicode.progetto.entities;

import epicode.progetto.Enum.StatoLocation;
import epicode.progetto.Enum.TipoLocation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "location")
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long codiceUnivoco;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoLocation tipo;
    @Enumerated(EnumType.STRING)
    private StatoLocation stato;
    private  int nMaxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "location")
    private List<Prenotazione> prenotazioni;

    public Location(Long codiceUnivoco, String descrizione, TipoLocation tipo, StatoLocation stato, int nMaxOccupanti,Edificio edificio) {
        this.codiceUnivoco = codiceUnivoco;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.stato = stato;
        this.nMaxOccupanti = nMaxOccupanti;
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "Location -> " +
                "codiceUnivoco=" + codiceUnivoco +
                ", descrizione='" + descrizione + '\'' +
                ", tipo=" + tipo +
                ", stato=" + stato +
                ", nMaxOccupanti=" + nMaxOccupanti +
                ", edificio=" + edificio +
                ' ';
    }
}


package epicode.progetto.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "utente")
@NoArgsConstructor
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String name;
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    public Utente(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utente -> " +
                  username + '\'' +
                ", " + name + '\'' +
                ", " + email + '\'' +
                '}';
    }
}

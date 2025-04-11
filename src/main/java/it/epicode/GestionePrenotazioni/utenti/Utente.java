package it.epicode.GestionePrenotazioni.utenti;

import it.epicode.GestionePrenotazioni.prenotazioni.Prenotazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 50, nullable = false)
    private String nomeCompleto;

    @Column(length = 50, nullable = false)
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    @Override
    public String toString() {
        return "Utente{" +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                '}';
    }
}

package it.epicode.GestionePrenotazioni.prenotazioni;

import it.epicode.GestionePrenotazioni.postazioni.Postazione;
import it.epicode.GestionePrenotazioni.utenti.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private LocalDate dataPrenotazione;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @Override
    public String toString() {
        return "Prenotazioni {" +
                "id= " + id + " " +
                postazione + " " +
                utente + " " +
                '}';
    }
}

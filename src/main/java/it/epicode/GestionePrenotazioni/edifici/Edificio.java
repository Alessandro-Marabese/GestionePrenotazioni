package it.epicode.GestionePrenotazioni.edifici;

import it.epicode.GestionePrenotazioni.postazioni.Postazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "edifici")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String indirizzo;

    @Column(length = 50, nullable = false)
    private String citta;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;

    @Override
    public String toString() {
        return "Edificio{" +
                "nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}

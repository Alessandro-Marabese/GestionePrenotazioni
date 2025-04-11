package it.epicode.GestionePrenotazioni.edifici;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
    Edificio findByNome(String nome);
    List<Edificio> findAllByCitta(String citta);
    Edificio findByIndirizzo(String indirizzo);
}

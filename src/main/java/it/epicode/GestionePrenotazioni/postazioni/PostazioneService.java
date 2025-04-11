package it.epicode.GestionePrenotazioni.postazioni;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }

    public Postazione findByCodice(String codice) {
        return postazioneRepository.findByCodice(codice);
    }

    public void save(Postazione postazione) {
        if(postazione.getCodice() == null) {
            throw new IllegalArgumentException("Il codice della postazione non può essere nullo");
        }
        if(postazione.getDescrizione() == null) {
            throw new IllegalArgumentException("La descrizione della postazione non può essere nullo");
        }
        if(postazione.getTipo() == null) {
            throw new IllegalArgumentException("Il tipo della postazione non può essere nullo");
        }
        if(postazione.getNumeroMassimoOccupanti() == 0) {
            throw new IllegalArgumentException("Il numero massimo di occupanti della postazione non può essere 0");
        }
        postazioneRepository.save(postazione);
    }
}

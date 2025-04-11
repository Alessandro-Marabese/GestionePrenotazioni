package it.epicode.GestionePrenotazioni.prenotazioni;

import it.epicode.GestionePrenotazioni.postazioni.Postazione;
import it.epicode.GestionePrenotazioni.postazioni.PostazioneRepository;
import it.epicode.GestionePrenotazioni.utenti.Utente;
import it.epicode.GestionePrenotazioni.utenti.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public Prenotazione findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione) {
        return prenotazioneRepository.findByUtenteAndDataPrenotazione(utente, dataPrenotazione);
    }

    public Prenotazione findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione) {
        return prenotazioneRepository.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
    }

    public List<Prenotazione> findByUtente(Utente utente) {
        return prenotazioneRepository.findByUtente(utente);
    }

    public String prenotaPostazione(String username, String codicePostazione, LocalDate dataPrenotazione) {
        Utente utente = utenteRepository.findByUsername(username);
        Postazione postazione = postazioneRepository.findByCodice(codicePostazione);

        if(utente == null) {
            return "Utente non trovato";
        }
        if(postazione == null) {
            return "Postazione non trovata";
        }

        Prenotazione prenotazioneEsistenteUtente = findByUtenteAndDataPrenotazione(utente, dataPrenotazione);
        if(prenotazioneEsistenteUtente != null) {
            return "L'utente ha già una prenotazione per quella data";
        }

        Prenotazione prenotazioneEsistentePostazione = findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
        if(prenotazioneEsistentePostazione != null) {
            return "La postazione ha gia' una prenotazione per quella data";
        }

        Prenotazione prenotazione = Prenotazione.builder()
                .dataPrenotazione(dataPrenotazione)
                .postazione(postazione)
                .utente(utente)
                .build();

        prenotazioneRepository.save(prenotazione);

        return "Prenotazione effettuata con successo";
    }

    public void save(Prenotazione prenotazione) {
        if(prenotazione.getDataPrenotazione() == null) {
            throw new IllegalArgumentException("La data della prenotazione non può essere nulla");
        }
        prenotazioneRepository.save(prenotazione);
    }
}

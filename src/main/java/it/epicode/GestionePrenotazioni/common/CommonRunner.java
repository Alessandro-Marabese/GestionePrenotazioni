package it.epicode.GestionePrenotazioni.common;

import it.epicode.GestionePrenotazioni.edifici.Edificio;
import it.epicode.GestionePrenotazioni.edifici.EdificioRepository;
import it.epicode.GestionePrenotazioni.postazioni.Postazione;
import it.epicode.GestionePrenotazioni.postazioni.PostazioneRepository;
import it.epicode.GestionePrenotazioni.postazioni.TipoPostazione;
import it.epicode.GestionePrenotazioni.prenotazioni.Prenotazione;
import it.epicode.GestionePrenotazioni.prenotazioni.PrenotazioneRepository;
import it.epicode.GestionePrenotazioni.prenotazioni.PrenotazioneService;
import it.epicode.GestionePrenotazioni.utenti.Utente;
import it.epicode.GestionePrenotazioni.utenti.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class CommonRunner implements CommandLineRunner {
    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {
        Utente utente1 = Utente.builder()
                .username("mrossi")
                .nomeCompleto("Mario Rossi")
                .email("mario.rossi@gmail.com")
                .build();

        Utente utente2 = Utente.builder()
                .username("lbianchi")
                .nomeCompleto("Laura Bianchi")
                .email("laura.bianchi@gmail.com")
                .build();

        //utenteRepository.saveAll(List.of(utente1, utente2));

        Edificio edificio1 = Edificio.builder()
                .nome("Sede Milano")
                .indirizzo("Via Montenapoleone 10")
                .citta("Milano")
                .build();

        Edificio edificio2 = Edificio.builder()
                .nome("Sede Roma")
                .indirizzo("Via Appia 42")
                .citta("Roma")
                .build();

        //edificioRepository.saveAll(List.of(edificio1, edificio2));

        Postazione postazione1 = Postazione.builder()
                .codice("MIL-01")
                .descrizione("Privato con finestra")
                .tipo(TipoPostazione.PRIVATO)
                .numeroMassimoOccupanti(1)
                .edificio(edificio1)
                .build();

        Postazione postazione2 = Postazione.builder()
                .codice("MIL-02")
                .descrizione("Sala riunioni con lavagna")
                .tipo(TipoPostazione.SALA_RIUNIONI)
                .numeroMassimoOccupanti(6)
                .edificio(edificio1)
                .build();

        Postazione postazione3 = Postazione.builder()
                .codice("ROM-01")
                .descrizione("Open space con vista su Colosseo")
                .tipo(TipoPostazione.OPENSPACE)
                .numeroMassimoOccupanti(4)
                .edificio(edificio2)
                .build();

        Postazione postazione4 = Postazione.builder()
                .codice("ROM-02")
                .descrizione("Privato")
                .tipo(TipoPostazione.PRIVATO)
                .numeroMassimoOccupanti(2)
                .edificio(edificio2)
                .build();

        //postazioneRepository.saveAll(List.of(postazione1, postazione2, postazione3, postazione4));


        /*System.out.println("******************");
        System.out.println(prenotazioneService.prenotaPostazione("lbianchi", "MIL-01", LocalDate.now().plusDays(3)));
        System.out.println("******************");

        System.out.println("******************");
        System.out.println(prenotazioneService.prenotaPostazione("mrossi", "ROM-01", LocalDate.now().plusDays(4)));
        System.out.println("******************");

        System.out.println("******************");
        System.out.println(prenotazioneService.prenotaPostazione("mrossi", "ROM-02", LocalDate.now().plusDays(4)));
        System.out.println("******************");*/

        System.out.println("******************");
        System.out.println(prenotazioneService.prenotaPostazione("mrossi", "MIL-02", LocalDate.now().plusDays(4)));
        System.out.println("******************");
    }
}

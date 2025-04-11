package it.epicode.GestionePrenotazioni.utenti;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public Utente findByUsername(String username) {
        return utenteRepository.findByUsername(username);
    }

    public Utente findByNomeCompleto(String nomeCompleto) {
        return utenteRepository.findByNomeCompleto(nomeCompleto);
    }

    public Utente findByEmail(String email) {
        return utenteRepository.findByEmail(email);
    }

    public void save(Utente utente) {
        if(utente.getUsername() == null) {
            throw new IllegalArgumentException("Il nome utente non può essere nullo");
        }
        if(utente.getNomeCompleto() == null) {
            throw new IllegalArgumentException("Il nome utente non può essere nullo");
        }
        if(utente.getEmail() == null) {
            throw new IllegalArgumentException("L'email utente non cazzo essere nullo");
        }
        utenteRepository.save(utente);
    }
}

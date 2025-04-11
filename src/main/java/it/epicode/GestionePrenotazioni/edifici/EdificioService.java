package it.epicode.GestionePrenotazioni.edifici;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public void save(Edificio edificio) {
        if(edificio.getNome() == null) {
            throw new IllegalArgumentException("Il nome dell'edificio non può essere nullo");
        }
        if(edificio.getIndirizzo() == null) {
            throw new IllegalArgumentException("L'indirizzo dell'edificio non può essere nullo");
        }
        if(edificio.getCitta() == null) {
            throw new IllegalArgumentException("La citta dell'edificio non può essere nullo");
        }
        edificioRepository.save(edificio);
    }
}

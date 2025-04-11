package it.epicode.GestionePrenotazioni.edifici;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public Edificio findByNome(String nome) {
        return edificioRepository.findByNome(nome);
    }

    public Edificio findByIndirizzo(String indirizzo) {
        return edificioRepository.findByIndirizzo(indirizzo);
    }

    public List<Edificio> findAllByCitta(String citta) {
        return edificioRepository.findAllByCitta(citta);
    }

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

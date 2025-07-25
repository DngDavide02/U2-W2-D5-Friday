package dangelodavide.U2_W2_D4_Friday.services;

import dangelodavide.U2_W2_D4_Friday.entities.Prenotazione;
import dangelodavide.U2_W2_D4_Friday.repository.PrenotazioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrenotazioneService {
    private final PrenotazioneRepository repository;

    public PrenotazioneService(PrenotazioneRepository repository) {
        this.repository = repository;
    }

    public List<Prenotazione> findAll(){
        return repository.findAll();
    }

    public Prenotazione save(Prenotazione prenotazione){
        return repository.save(prenotazione);
    }

    public Prenotazione findById(UUID id){
        return repository.findById(id).orElseThrow();
    }

    public void deleteById(UUID id){
        repository.deleteById(id);
    }
}

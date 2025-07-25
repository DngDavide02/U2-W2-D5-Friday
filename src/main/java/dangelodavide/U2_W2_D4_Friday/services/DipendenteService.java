package dangelodavide.U2_W2_D4_Friday.services;

import dangelodavide.U2_W2_D4_Friday.entities.Dipendente;
import dangelodavide.U2_W2_D4_Friday.repository.DipendenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DipendenteService {
    private final DipendenteRepository repository;

    public DipendenteService(DipendenteRepository repository){
        this.repository = repository;
    }

    public List<Dipendente> findAll(){
        return repository.findAll();
    }

    public Dipendente save(Dipendente dipendente){
        return repository.save(dipendente);
    }

    public Dipendente findById(UUID id){
        return repository.findById(id).orElseThrow();
    }

    public void deleteById(UUID id){
        repository.deleteById(id);
    }
}

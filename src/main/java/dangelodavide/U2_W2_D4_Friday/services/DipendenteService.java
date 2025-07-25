package dangelodavide.U2_W2_D4_Friday.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import dangelodavide.U2_W2_D4_Friday.entities.Dipendente;
import dangelodavide.U2_W2_D4_Friday.exceptions.BadRequestException;
import dangelodavide.U2_W2_D4_Friday.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class DipendenteService {
    @Autowired
    private final DipendenteRepository repository;
    @Autowired
    private Cloudinary cloudinary;

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

    public String uploadAvatar(UUID dipendenteId, MultipartFile file) {
        try {
            Dipendente dip = repository.findById(dipendenteId)
                    .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

            Map<?, ?> result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String imageURL = (String) result.get("secure_url"); // secure_url è consigliato

            dip.setImmagineProfiloPath(imageURL);
            repository.save(dip);

            return imageURL;
        } catch (Exception e) {
            throw new BadRequestException("Ci sono stati problemi nel salvataggio del file!");
        }
    }

}

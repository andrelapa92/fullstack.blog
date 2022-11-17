package fullstack.blog.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fullstack.blog.entities.Assunto;
import fullstack.blog.repositories.AssuntoRepository;

@Service
public class AssuntoService {
    
    @Autowired
    private AssuntoRepository assuntoRepository;

    //GET
    public List<Assunto> findAll() {
        return assuntoRepository.findAll();
    }

    //GET{id}
    public Assunto findById (Long Id){
        return assuntoRepository.findById(Id).get();  
    }
    
    //POST
    public Assunto save (Assunto assunto){
        return assuntoRepository.save(assunto);
    }

    //DELETE
    public void delete (Long id){
       assuntoRepository.deleteById(id);
    }
    
    //PUT
    public Assunto update (Long id, Assunto assunto){
        Assunto assuntoEntity = assuntoRepository.getReferenceById(id);
        assuntoEntity.setDescricao(assunto.getDescricao());
        return assuntoRepository.save(assuntoEntity);
    }

}
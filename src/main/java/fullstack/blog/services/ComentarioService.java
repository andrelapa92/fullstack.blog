package fullstack.blog.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fullstack.blog.entities.Comentario;
import fullstack.blog.repositories.ComentarioRepository;

@Service
public class ComentarioService {

    
    @Autowired
    private ComentarioRepository comentarioRepository;
    
    //GET
    public List <Comentario> findAll(){
        return comentarioRepository.findAll();
    }
   
    //GET{id}
    public Comentario findById (Long Id){
        return comentarioRepository.findById(Id).get();
    }
    
    //POST
    public Comentario save (Comentario comentario){
        return comentarioRepository.save(comentario);
    }

    //DELETE
    public void delete (Long id){
       comentarioRepository.deleteById(id);
    }
    
    //PUT
    public Comentario update (Long id, Comentario comentario){
        Comentario comentarioEntity = comentarioRepository.getReferenceById(id);
        comentarioEntity.setNome(comentario.getNome());
        comentarioEntity.setData(comentario.getData());
        comentarioEntity.setText(comentario.getText());
        return comentarioRepository.save(comentarioEntity);
    }


}
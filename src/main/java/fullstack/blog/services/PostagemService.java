package fullstack.blog.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fullstack.blog.entities.Assunto;
import fullstack.blog.entities.Comentario;
import fullstack.blog.entities.Postagem;
import fullstack.blog.repositories.AssuntoRepository;
import fullstack.blog.repositories.ComentarioRepository;
import fullstack.blog.repositories.PostagemRepository;

@Service
public class PostagemService {
    
    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;
    
    @Autowired
    private AssuntoRepository assuntoRepository;

    //Get
    public List <Postagem> findAll(){
        return postagemRepository.findAll();
    }
   
    //GET{id}
    public Postagem findById (Long  id){
        return postagemRepository.findById(id).get();
    }
    
    //POST
    public Postagem save (Postagem postagem){
        return postagemRepository.save(postagem);
    }

    //DELETE
    public void delete (Long id){
       postagemRepository.deleteById(id);
    }
    
    //PUT
    public Postagem update (Long id, Postagem postagem){
        Postagem postagemEntity = postagemRepository.getReferenceById(id);
        postagemEntity.setData(postagem.getData());
        postagemEntity.setTitulo(postagem.getTitulo());
        postagemEntity.setTitulo(postagem.getTitulo());
        postagemEntity.setEditor(postagem.getEditor());
        return postagemRepository.save(postagemEntity);
    }
    
    //Adicionando comentário
    public Postagem addComentario ( Long id_postagem, Long id_comentario){
        Postagem postagem = postagemRepository.findById(id_postagem).get();
        Comentario comentario = comentarioRepository.findById(id_comentario).get();
        comentario.setPostagem(postagem);
        comentarioRepository.save(comentario);
        return postagem;
    }

    //Adicionando assunto
    public Postagem addAssunto(Long id_postagem, Long id_assunto){
        Postagem postagem = postagemRepository.findById(id_postagem).get();
        Assunto assunto = assuntoRepository.findById(id_assunto).get();
        postagem.getAssuntos().add(assunto);
        postagemRepository.save(postagem);
        return postagem;
    }

    //Removendo comentário
    public Postagem removeComentario(Long id_postagem, Long id_comentario){
        Postagem postagem = postagemRepository.findById(id_postagem).get();
        Comentario comentario = comentarioRepository.findById(id_comentario).get();
        comentario.setPostagem(null);
        comentarioRepository.save(comentario);
        return postagem;
    }

    //Removendo assunto
    public Postagem removeAssunto(Long id_postagem, Long id_assunto){
        Postagem postagem = postagemRepository.findById(id_postagem).get();
        Assunto assunto = assuntoRepository.findById(id_assunto).get();
        postagem.getAssuntos().remove(assunto);
        postagemRepository.save(postagem);
        return postagem;
}


}
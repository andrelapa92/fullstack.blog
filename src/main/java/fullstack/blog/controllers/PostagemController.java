package fullstack.blog.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import fullstack.blog.entities.Postagem;
import fullstack.blog.services.PostagemService;

@RestController
public class PostagemController {
    
    @Autowired
    private PostagemService postagemService;

    //GET
    @GetMapping(value = "/postagens")
    public ResponseEntity < List<Postagem> > findAll() {
        List<Postagem> postagens = postagemService.findAll();
        return ResponseEntity.ok().body(postagens);
    }
    
    //GET{id}
    @GetMapping(value = "/postagens/{id}")
    public ResponseEntity <Postagem> findById(@PathVariable Long id) {
        Postagem postagem = postagemService.findById(id);
        return ResponseEntity.ok().body(postagem);
    }
    
    //POST
    @PostMapping(value = "/postagens")
    public ResponseEntity <Postagem> save (@RequestBody Postagem postagem) {
       Postagem savedPostagem = postagemService.save(postagem);
       URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("postagens/{id}").buildAndExpand(savedPostagem.getId()).toUri();
       return ResponseEntity.created(uri).body(savedPostagem);
    }
    
    //DELETE
    //Deletando postagem
    @DeleteMapping(value = "/postagens/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id) {
       postagemService.delete(id);
       return ResponseEntity.noContent().build();
    }
    
    //PUT
    //Adicionando postagem
    @PutMapping(value = "/postagens/{id}")
    public ResponseEntity <Postagem> update (@PathVariable Long id, @RequestBody Postagem postagem) {
        postagem = postagemService.update(id, postagem);
        return ResponseEntity.ok().body(postagem);
    }
    
    //Adicionando comentário
    @PutMapping(value = "/postagens/{id_postagem}/addComentario/{id_comentario}")
    public ResponseEntity <Postagem> addComentario(@PathVariable Long id_postagem, @PathVariable Long id_comentario) {
        Postagem postagem = postagemService.addComentario(id_postagem, id_comentario);
        return ResponseEntity.ok().body(postagem);
    }
    
    //Adicionando assunto
    @PutMapping(value = "/postagens/{id_postagem}/addAssunto/{id_assunto}")
    public ResponseEntity <Postagem> addAssunto(@PathVariable Long id_postagem, @PathVariable Long id_assunto) {
        Postagem postagem = postagemService.addAssunto(id_postagem, id_assunto);
        return ResponseEntity.ok().body(postagem);
    }
    
    //DELETE
    //Deletando comentário
    @DeleteMapping(value = "/postagens/{id_postagem}/removeComentario/{id_comentario}")
    public ResponseEntity <Postagem> removeComentario (@PathVariable Long id_postagem, @PathVariable Long id_comentario) {
        Postagem postagem = postagemService.removeComentario(id_postagem, id_comentario);
        return ResponseEntity.ok().body(postagem);
    }
    
    //Deletando assunto
    @DeleteMapping(value = "/postagens/{id_postagem}/removeAssunto/{id_assunto}")
    public ResponseEntity <Postagem> removeAssunto (@PathVariable Long id_postagem, @PathVariable Long id_assunto) {
        Postagem postagem = postagemService.removeAssunto(id_postagem, id_assunto);
        return ResponseEntity.ok().body(postagem);
    }


}
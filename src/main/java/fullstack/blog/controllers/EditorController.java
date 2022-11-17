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
import fullstack.blog.entities.Editor;
import fullstack.blog.services.EditorService;

@RestController
public class EditorController {
    
    @Autowired
    private EditorService editorService;
    
    //GET
    @GetMapping(value = "/editores")
    public ResponseEntity <List<Editor>> findAll() {
        List<Editor> editores = editorService.findAll();
        return ResponseEntity.ok().body(editores);
    }
    
    //GET{id}
    @GetMapping(value = "/editores/{id}")
    public ResponseEntity <Editor> findById(@PathVariable Long id) {
        Editor editor = editorService.findById(id);
        return ResponseEntity.ok().body(editor);
    }
    
    //POST
    @PostMapping(value = "/editores")
    public ResponseEntity <Editor> save (@RequestBody Editor editor) {
       Editor savedEditor = editorService.save(editor);
       URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("editores/{id}").buildAndExpand(savedEditor.getId()).toUri();
       return ResponseEntity.created(uri).body(savedEditor);
    }
    
    //DELETE
    @DeleteMapping(value = "/editores/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id) {
       editorService.delete(id);
       return ResponseEntity.noContent().build();
    }
    
    //PUT
    @PutMapping(value = "/editores/{id}")
    public ResponseEntity <Editor> update (@PathVariable Long id, @RequestBody Editor editor) {
        editor = editorService.update(id, editor);
        return ResponseEntity.ok().body(editor);
    }
    
    //Criando postagem
    @PutMapping(value = "/editores/{id_editor}/addPostagem/{id_postagem}")
    public ResponseEntity <Editor> addPostagem(@PathVariable Long id_editor, @PathVariable Long id_postagem) {
        Editor editor = editorService.addPostagem(id_editor, id_postagem);
        return ResponseEntity.ok().body(editor);
    }

    //Excluindo postagem
    @DeleteMapping(value = "/editores/{id_editor}/removePostagem/{id_postagem}")
    public ResponseEntity <Editor> removePostagem (@PathVariable Long id_editor, @PathVariable Long id_postagem) {
        Editor editor = editorService.removePostagem(id_editor, id_postagem);
        return ResponseEntity.ok().body(editor);
    }


}
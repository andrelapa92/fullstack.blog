package fullstack.blog.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fullstack.blog.entities.Editor;
import fullstack.blog.entities.Postagem;
import fullstack.blog.repositories.EditorRepository;
import fullstack.blog.repositories.PostagemRepository;

@Service
public class EditorService {
    
    @Autowired
    private EditorRepository editorRepository;

    @Autowired
    private PostagemRepository postagemRepository;

    //GET
    public List<Editor> findAll() {
        return editorRepository.findAll();
    }

    //GET{id}
    public Editor findById (Long Id){
        return editorRepository.findById(Id).get();
    }
    
    //POST
    public Editor save (Editor editor){
        return editorRepository.save(editor);
    }
    
    //DELETE
    public void delete (Long id){
        editorRepository.deleteById(id);
    }
    
    //PUT
    public Editor update (Long id, Editor editor){
        Editor editorEntity = editorRepository.getReferenceById(id);
        editorEntity.setNome(editor.getNome());
        editorEntity.setSenha(editor.getSenha());
        return editorRepository.save(editorEntity);
    }

    //Adicionando editor
    public Editor addPostagem( Long id_editor, Long id_postagem){
        Editor editor = editorRepository.findById(id_editor).get();
        Postagem postagem = postagemRepository.findById(id_postagem).get();
        postagem.setEditor(editor);
        postagemRepository.save(postagem);
        return editor;
    }

    //Removendo editor
    public Editor removePostagem(Long id_editor, Long id_postagem){
        Editor editor = editorRepository.findById(id_editor).get();
        Postagem postagem = postagemRepository.findById(id_postagem).get();
        postagem.setEditor(null);
        postagemRepository.save(postagem);
        return editor;
    }

}
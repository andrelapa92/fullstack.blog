package fullstack.blog.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Postagem implements Serializable {
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant data;
    private String titulo;
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_editor")
    private Editor editor;

    @ManyToMany
    @JoinTable(name = "postagem_assunto", joinColumns = @JoinColumn(name = "id_postagem"), 
            inverseJoinColumns  = @JoinColumn(name = "id_assunto"))
    private Set<Assunto> assuntos = new HashSet<>();

    @OneToMany(mappedBy = "postagem")
    private Set<Comentario> comentarios = new HashSet<>();


    public Postagem() {}

    public Postagem(Long id, Instant data, String titulo, String texto) {
        this.id = id;
        this.data = data;
        this.titulo = titulo;
        this.texto = texto;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Set<Assunto> getAssuntos() {
        return assuntos;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public Double getTotalPalavras() {
        String texto = this.texto;
        String[] words = texto.split("\\s+");
        double contagem = words.length;
        return contagem;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Postagem other = (Postagem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
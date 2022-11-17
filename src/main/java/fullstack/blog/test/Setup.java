package fullstack.blog.test;

import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import fullstack.blog.entities.Assunto;
import fullstack.blog.entities.Comentario;
import fullstack.blog.entities.Editor;
import fullstack.blog.entities.Postagem;
import fullstack.blog.repositories.AssuntoRepository;
import fullstack.blog.repositories.ComentarioRepository;
import fullstack.blog.repositories.EditorRepository;
import fullstack.blog.repositories.PostagemRepository;

@Configuration
@Profile("test")
public class Setup implements CommandLineRunner {

    @Autowired
    private PostagemRepository postagemRepository;
    @Autowired
    private EditorRepository editorRepository;
    @Autowired
    private AssuntoRepository assuntoRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;
    
    @Override
    public void run(String... args) throws Exception {

        //Criando postagens
        Postagem p1 = new Postagem(null, Instant.parse("2020-10-20T10:30:42Z"), "Relacionamentos com Spring Boot", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        Postagem p2 = new Postagem(null, Instant.parse("2021-02-27T14:18:26Z"), "Criando uma página com React", "Mauris risus quam, consequat a finibus at, vulputate in massa.");
        Postagem p3 = new Postagem(null, Instant.parse("2022-05-16T12:11:39Z"), "Primeiros passos em JavaScript", "Vivamus euismod aliquet dolor sed consequat.");
        Postagem p4 = new Postagem(null, Instant.parse("2022-06-02T07:29:48Z"), "Herança de classes em Java", "Morbi lobortis enim nec purus tempus commodo.");
        
        postagemRepository.saveAll(Arrays.asList(p1, p2, p3));

        //Criando editores
        Editor e1 = new Editor(null, "Edson Arantes", "ean2022");
        Editor e2 = new Editor(null, "Manoel Francisco", "mfs123");
        Editor e3 = new Editor(null, "Marcos André", "mabs@vampeta3");
        
        editorRepository.saveAll(Arrays.asList(e1, e2, e3));

        //Associando postagens com os editores
        p1.setEditor(e1);
        p2.setEditor(e2);
        p3.setEditor(e2);
        p4.setEditor(e3);

        //Criando assuntos
        Assunto a1 = new Assunto(null, "Java");
        Assunto a2 = new Assunto(null, "Spring Boot");
        Assunto a3 = new Assunto(null, "Back-End");
        Assunto a4 = new Assunto(null, "Front-End");
        Assunto a5 = new Assunto(null, "JavaScript");
        
        assuntoRepository.saveAll(Arrays.asList(a1, a2, a3, a4, a5));

        //Associando postagens com assuntos
        p1.getAssuntos().add(a1);
        p1.getAssuntos().add(a2);
        p1.getAssuntos().add(a3);
        p2.getAssuntos().add(a4);
        p2.getAssuntos().add(a5);
        p3.getAssuntos().add(a5);
        p4.getAssuntos().add(a1);

        //Criando comentários
        Comentario c1 = new Comentario(null, "Francisco Everardo", Instant.parse("2021-05-17T08:02:49Z"), "Ótimo post, parabéns! Consegui tirar muitas dúvidas sobre Spring Boot.", p1);
        Comentario c2 = new Comentario(null, "Everson de Brito", Instant.parse("2021-03-02T19:13:36Z"), "Muito bom, já estou apaixonado por React.", p2);
        Comentario c3 = new Comentario(null, "Daniella Maria", Instant.parse("2022-09-30T10:02:14Z"), "Adorei! Poderia explicar como funcionam os loops em JS?", p3);
        Comentario c4 = new Comentario(null, "Augusto Liberato", Instant.parse("2021-01-06T15:51:27Z"), "O Spring facilita muito o relacionamento entre tabelas.", p1);
        comentarioRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

        postagemRepository.saveAll(Arrays.asList(p1, p2, p3, p4));


    }
    
}
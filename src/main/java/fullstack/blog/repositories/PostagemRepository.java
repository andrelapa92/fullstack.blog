package fullstack.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fullstack.blog.entities.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    
}
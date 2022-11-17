package fullstack.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fullstack.blog.entities.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    
}
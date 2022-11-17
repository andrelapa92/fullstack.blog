package fullstack.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fullstack.blog.entities.Assunto;

public interface AssuntoRepository extends JpaRepository<Assunto, Long> {
    
}
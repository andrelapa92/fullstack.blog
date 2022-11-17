package fullstack.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import fullstack.blog.entities.Editor;

public interface EditorRepository extends JpaRepository<Editor, Long> {
    
}
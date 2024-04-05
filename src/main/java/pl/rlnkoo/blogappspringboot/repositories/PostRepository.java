package pl.rlnkoo.blogappspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rlnkoo.blogappspringboot.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}

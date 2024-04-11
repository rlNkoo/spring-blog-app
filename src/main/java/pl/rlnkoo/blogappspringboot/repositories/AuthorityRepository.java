package pl.rlnkoo.blogappspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rlnkoo.blogappspringboot.models.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}

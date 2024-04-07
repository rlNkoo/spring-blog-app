package pl.rlnkoo.blogappspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rlnkoo.blogappspringboot.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}

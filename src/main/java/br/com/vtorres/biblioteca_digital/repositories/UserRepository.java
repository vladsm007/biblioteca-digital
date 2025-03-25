package br.com.vtorres.biblioteca_digital.repositories;

import br.com.vtorres.biblioteca_digital.entities.Book;
import br.com.vtorres.biblioteca_digital.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameContainingIgnoreCase(String name);
    boolean existsByEmail(String email);
}

package br.com.vtorres.biblioteca_digital.repositories;

import br.com.vtorres.biblioteca_digital.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByNameContainingIgnoreCase(String name);
}

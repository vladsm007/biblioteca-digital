package br.com.vtorres.biblioteca_digital.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.GenerationType.*;

@Setter
@Getter
@Entity
@Table(name = "tb_books")
@Data
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private String author;

    public Book() {
    }

    public Book(Long id, String name, String genre, String author) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
    }
}

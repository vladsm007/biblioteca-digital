package br.com.vtorres.biblioteca_digital.service;

import br.com.vtorres.biblioteca_digital.entities.Book;

import java.util.List;


public interface BookService {

    Book createBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);
    List<Book> findBookByName(String name);


}

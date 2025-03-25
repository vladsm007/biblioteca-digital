package br.com.vtorres.biblioteca_digital.service;

import br.com.vtorres.biblioteca_digital.entities.Book;
import br.com.vtorres.biblioteca_digital.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        if (book.getName() == null || book.getName().isEmpty()){
            throw new IllegalArgumentException("O nome do livro não pode ficar vazio.");
        }else{
            return bookRepository.save(book);
        }

    }

    @Override
        public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Livro não encontrado."));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook = getBookById(id);
        existingBook.setName(book.getName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setGenre(book.getGenre());
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
        System.out.println("Livro deletado com sucesso.");
    }

    @Override
    public List<Book> findBookByName(String name) {
        return bookRepository.findByNameContainingIgnoreCase(name);
    }
}

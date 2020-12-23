package com.example.demo.resources;

import com.example.demo.entities.Book;
import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.repositories.BookRepository;
import com.example.dto.BookDTO;
import com.example.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookResource {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> retrieveAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book retrieveBook(@PathVariable long id) {
        Optional<Book> Book = bookRepository.findById(id);

        if (!Book.isPresent())
            throw new BookNotFoundException("id-" + id);

        return Book.get();
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable long id) {
        bookRepository.deleteById(id);
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);

    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody BookDTO bookDTO, @PathVariable long id) {

        Optional<Book> bookOptional = bookRepository.findById(id);

        if (!bookOptional.isPresent())
            throw new BookNotFoundException("id-" + id);

        BookMapper.INSTANCE.updateBookFromDto(bookDTO, bookOptional.get());
        bookRepository.save(bookOptional.get());

        return bookOptional.get();
    }
}

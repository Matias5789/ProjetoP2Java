package com.biblioteca.emprestimo_livros.services;

import com.biblioteca.emprestimo_livros.model.Book;
import com.biblioteca.emprestimo_livros.model.Status;
import com.biblioteca.emprestimo_livros.repositorys.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book bookRequest) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
        existingBook.setTitle(bookRequest.getTitle());
        existingBook.setAuthor(bookRequest.getAuthor());
        existingBook.setIsbn(bookRequest.getIsbn());
        existingBook.setPublishedDate(bookRequest.getPublishedDate());
        return bookRepository.save(existingBook);
    }

    public Book updateBookStatus(Long id, Status status) {
        Book book = findById(id).orElseThrow(() -> new NoSuchElementException("Livro não encontrado com o ID: " + id));
        book.setStatus(status);
        return bookRepository.save(book);
    }

}

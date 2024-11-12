package com.biblioteca.emprestimo_livros.repositorys;

import com.biblioteca.emprestimo_livros.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b")
    List<Book> findAllBooks();

    @Query("SELECT b FROM Book b WHERE b.title = :title")
    List<Book> findBooksByTitle(@Param("title") String title);

    @Query("SELECT b FROM Book b WHERE b.author = :author")
    List<Book> findBooksByAuthor(@Param("author") String author);
}

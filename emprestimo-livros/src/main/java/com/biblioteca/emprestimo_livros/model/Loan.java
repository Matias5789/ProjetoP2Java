package com.biblioteca.emprestimo_livros.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Loan implements Serializable {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")  // Faz a associação com a tabela Customer
    private Customer customer;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "loan_books", // Nome da tabela de junção
        joinColumns = @JoinColumn(name = "loan_id"), // Chave estrangeira para Loan
        inverseJoinColumns = @JoinColumn(name = "book_id") // Chave estrangeira para Book
    )
    private List<Book> books;
    
    private String author;
    private String isbn;
    private LocalDate publishedDate;
    
    @Enumerated(EnumType.STRING)
    private Status status; //esse é o status do livro.

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "completed_date")
    private LocalDate completedDate;
}

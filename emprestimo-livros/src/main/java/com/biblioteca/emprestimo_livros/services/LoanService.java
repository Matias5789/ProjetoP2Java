package com.biblioteca.emprestimo_livros.services;

import com.biblioteca.emprestimo_livros.DTO.LoanRequestDTO;
import com.biblioteca.emprestimo_livros.model.Book;
import com.biblioteca.emprestimo_livros.model.Customer;
import com.biblioteca.emprestimo_livros.model.Loan;
import com.biblioteca.emprestimo_livros.model.Status;
import com.biblioteca.emprestimo_livros.repositorys.BookRepository;
import com.biblioteca.emprestimo_livros.repositorys.CustomerRepository;
import com.biblioteca.emprestimo_livros.repositorys.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository CustomerRepository;  // Corrigido: variáveis de instância para repositórios

    @Autowired
    private BookRepository BookRepository;  // Corrigido: variáveis de instância para repositórios

    public List<Loan> findAllLoans() {
        return loanRepository.findAllLoans();
    }

    public List<Loan> findLoansByCustomerId(Long customerId) {
        return loanRepository.findLoansByCustomerId(customerId);
    }

    // Método para criar um empréstimo a partir de um DTO com os IDs dos livros e cliente
    public Loan createLoan(LoanRequestDTO loanRequest) {
        // Busca o cliente pelo ID
        Customer customer = CustomerRepository.findById(loanRequest.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Busca os livros pelos IDs
        List<Book> books = BookRepository.findAllById(loanRequest.getBookIds());
        if (books.isEmpty()) {
            throw new RuntimeException("Nenhum livro encontrado com os IDs fornecidos.");
        }

        // Lógica para garantir que os livros estão disponíveis
        for (Book book : books) {
            if (book.getStatus() != Status.AVAILABLE) {
                throw new RuntimeException("Livro " + book.getTitle() + " não está disponível.");
            }
        }

        // Criação do empréstimo
        Loan loan = new Loan();
        loan.setCustomer(customer);
        loan.setBooks(books);

        // Atualizar o status dos livros para "BORROWED"
        books.forEach(book -> book.setStatus(Status.BORROWED));
        BookRepository.saveAll(books);  // Salvando as alterações no status dos livros

        if (!books.isEmpty()) {
            // Assumindo que todos os livros têm os mesmos dados (caso contrário, use lógica mais complexa)
            Book firstBook = books.get(0);  // Pegue o primeiro livro para preencher os dados
            loan.setAuthor(firstBook.getAuthor());
            loan.setIsbn(firstBook.getIsbn());
            loan.setPublishedDate(firstBook.getPublishedDate());
            loan.setStatus(firstBook.getStatus());  // Supondo que você queira usar o status do primeiro livro
        }


        return loanRepository.save(loan);  // Salvando o empréstimo
    }


    public Loan extendLoan(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow();
        // Lógica para prorrogar o empréstimo
        return loanRepository.save(loan);
    }

    public Loan completeLoan(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow();
        // Lógica para completar o empréstimo e atualizar o status dos livros
        return loanRepository.save(loan);
    }
}

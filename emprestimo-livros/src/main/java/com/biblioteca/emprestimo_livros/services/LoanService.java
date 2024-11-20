package com.biblioteca.emprestimo_livros.services;

import com.biblioteca.emprestimo_livros.dto.LoanRequestDTO;
import com.biblioteca.emprestimo_livros.dto.LoanResponseDTO;
import com.biblioteca.emprestimo_livros.mapper.LoanMapper;
import com.biblioteca.emprestimo_livros.model.Book;
import com.biblioteca.emprestimo_livros.model.Customer;
import com.biblioteca.emprestimo_livros.model.Loan;
import com.biblioteca.emprestimo_livros.model.Status;
import com.biblioteca.emprestimo_livros.repositorys.BookRepository;
import com.biblioteca.emprestimo_livros.repositorys.CustomerRepository;
import com.biblioteca.emprestimo_livros.repositorys.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;  // Corrigido: variáveis de instância para repositórios

    @Autowired
    private BookRepository bookRepository;  // Corrigido: variáveis de instância para repositórios

    @Autowired
    private LoanMapper loanMapper;

    public List<Loan> findAllLoans() {
        return loanRepository.findAllLoans();
    }

    public LoanResponseDTO findLoanById(Long id) {
    Loan loan = loanRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado com o ID: " + id));
    
    return loanMapper.toLoanResponseDTO(loan);
    }

    public Loan createLoan(LoanRequestDTO loanRequest) {
        Customer customer = customerRepository.findById(loanRequest.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        List<Book> books = bookRepository.findAllById(loanRequest.getBookIds());
        if (books.isEmpty()) {
            throw new RuntimeException("Nenhum livro encontrado com os IDs fornecidos.");
        }

        for (Book book : books) {
            if (book.getStatus() != Status.AVAILABLE) {
                throw new RuntimeException("Livro " + book.getTitle() + " não está disponível.");
            }
        }
        Loan loan = new Loan();
        loan.setCustomer(customer);
        loan.setCreatedDate(LocalDate.now());
        loan.setCompletedDate(loan.getCreatedDate().plusWeeks(2));
        loan.setBooks(books);
        books.forEach(book -> book.setStatus(Status.BORROWED));
        bookRepository.saveAll(books);

        if (!books.isEmpty()) {
            Book firstBook = books.get(0);
            loan.setAuthor(firstBook.getAuthor());
            loan.setIsbn(firstBook.getIsbn());
            loan.setPublishedDate(firstBook.getPublishedDate());
            loan.setStatus(firstBook.getStatus());
        }


        return loanRepository.save(loan);
    }

    public Loan extendLoan(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
        if (loan.getStatus() != Status.BORROWED) {
            throw new IllegalStateException("Somente empréstimos ativos podem ser estendidos.");
        }
        LocalDate newCompletedDate = loan.getCompletedDate().plusWeeks(1);
        loan.setCompletedDate(newCompletedDate);
        return loanRepository.save(loan);
    }

    public Loan completeLoan(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));
        if (loan.getStatus() != Status.BORROWED) {
            throw new IllegalStateException("Somente empréstimos ativos podem ser completados.");
        }
        loan.setStatus(Status.AVAILABLE);
        List<Book> books = loan.getBooks();
        for (Book book : books) {
            if (book.getStatus() != Status.BORROWED) {
                throw new IllegalStateException("O livro com ID " + book.getId() + " não está emprestado.");
            }
            book.setStatus(Status.AVAILABLE);
            bookRepository.save(book);
        }
        return loanRepository.save(loan);
    }

    public List<LoanResponseDTO> findLoansByCreationDateRange(LocalDate startDate, LocalDate endDate) {
    List<Loan> loans = loanRepository.findLoansByCreationDateRange(startDate, endDate);
    return loans.stream()
                .map(loanMapper::toLoanResponseDTO)
                .collect(Collectors.toList());
}
}

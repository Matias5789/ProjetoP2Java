package com.biblioteca.emprestimo_livros.repositorys;

import com.biblioteca.emprestimo_livros.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("SELECT l FROM Loan l")
    List<Loan> findAllLoans();

    @Query("SELECT l FROM Loan l WHERE l.customer.id = ?1")
    List<Loan> findLoansByCustomerId(Long customerId);

    @Query("SELECT l FROM Loan l WHERE l.returned = false")
    List<Loan> findActiveLoans();
}

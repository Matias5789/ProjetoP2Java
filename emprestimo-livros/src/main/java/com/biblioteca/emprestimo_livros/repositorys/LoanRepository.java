package com.biblioteca.emprestimo_livros.repositorys;

import com.biblioteca.emprestimo_livros.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("SELECT l FROM Loan l")
    List<Loan> findAllLoans();

    @Query("SELECT l FROM Loan l WHERE l.id = ?1")
    Loan findLoanById(Long id);

    @Query("SELECT l FROM Loan l WHERE l.status = 'BORROWED'")
    List<Loan> findActiveLoans();

    @Query("SELECT l FROM Loan l WHERE l.createdDate BETWEEN :startDate AND :endDate")
    List<Loan> findLoansByCreationDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT l FROM Loan l WHERE l.customer.id = :customerId")
    List<Loan> findByCustomerId(@Param("customerId") Long customerId);
}

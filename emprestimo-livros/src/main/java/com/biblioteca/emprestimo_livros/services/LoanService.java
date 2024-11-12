package com.biblioteca.emprestimo_livros.services;

import com.biblioteca.emprestimo_livros.model.Loan;
import com.biblioteca.emprestimo_livros.repositorys.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> findAllLoans() {
        return loanRepository.findAllLoans();
    }

    public List<Loan> findLoansByCustomerId(Long customerId) {
        return loanRepository.findLoansByCustomerId(customerId);
    }

    public List<Loan> findActiveLoans() {
        return loanRepository.findActiveLoans();
    }

    public Optional<Loan> findById(Long id) {
        return loanRepository.findById(id);
    }

    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }

    public void deleteById(Long id) {
        loanRepository.deleteById(id);
    }
}

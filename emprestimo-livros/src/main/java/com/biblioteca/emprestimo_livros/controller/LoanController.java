package com.biblioteca.emprestimo_livros.controller;

import com.biblioteca.emprestimo_livros.DTO.LoanRequestDTO;
import com.biblioteca.emprestimo_livros.model.Loan;
import com.biblioteca.emprestimo_livros.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.findAllLoans());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Loan>> getLoansByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(loanService.findLoansByCustomerId(customerId));
    }

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody LoanRequestDTO loanRequestDTO) {
        Loan loan = loanService.createLoan(loanRequestDTO);
        return ResponseEntity.status(201).body(loan);
    }

    @PatchMapping("/{id}/extend")
    public ResponseEntity<Loan> extendLoan(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.extendLoan(id));
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Loan> completeLoan(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.completeLoan(id));
    }
}

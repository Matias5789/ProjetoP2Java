package com.biblioteca.emprestimo_livros.controller;

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

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Loan>> getLoansByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(loanService.findLoansByCustomer(customerId));
    }

    @GetMapping("/date")
    public ResponseEntity<List<Loan>> getLoansByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        return ResponseEntity.ok(loanService.findLoansByDateRange(startDate, endDate));
    }

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        return ResponseEntity.ok(loanService.createLoan(loan));
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

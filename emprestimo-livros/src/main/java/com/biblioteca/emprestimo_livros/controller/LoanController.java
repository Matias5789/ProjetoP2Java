package com.biblioteca.emprestimo_livros.controller;

import com.biblioteca.emprestimo_livros.dto.LoanRequestDTO;
import com.biblioteca.emprestimo_livros.dto.LoanResponseDTO;
import com.biblioteca.emprestimo_livros.model.Loan;
import com.biblioteca.emprestimo_livros.services.LoanService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/loans")
@Validated
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
        public ResponseEntity<List<LoanResponseDTO>> getLoansByCreationDateRange(
        @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
        @RequestParam @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<LoanResponseDTO> loans = loanService.findLoansByCreationDateRange(startDate, endDate);
        return ResponseEntity.ok(loans);  // Retorna a lista de LoanResponseDTO
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDTO> getLoanById(@PathVariable Long id) {
    LoanResponseDTO loan = loanService.findLoanById(id);
    return ResponseEntity.ok(loan);
    }

    @PostMapping
    public ResponseEntity<Loan> createLoan( @RequestBody @Valid LoanRequestDTO loanRequestDTO) {
        Loan loan = loanService.createLoan(loanRequestDTO);
        return ResponseEntity.status(201).body(loan);
    }

    @PatchMapping("/{id}/extend")
    public ResponseEntity<Loan> extendLoan(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.extendLoan(id));
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Loan> completeLoan(@PathVariable Long id) {
        Loan loan = loanService.completeLoan(id);  // Passa apenas o id para o service
        return ResponseEntity.ok(loan);  // Retorna o empréstimo atualizado
    }
}

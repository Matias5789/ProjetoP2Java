package com.biblioteca.emprestimo_livros.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponseDTO {

    private Long id;  // ID do empréstimo
    private Long customerId;  // ID do cliente
    private String customerName;  // Nome do cliente
    private List<String> bookTitles;  // Títulos dos livros emprestados
    private LocalDate createdDate; // Data de criação do empréstimo
    private LocalDate completedDate;
    private String status;  // Status do empréstimo
}

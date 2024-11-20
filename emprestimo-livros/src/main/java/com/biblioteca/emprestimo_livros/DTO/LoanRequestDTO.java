package com.biblioteca.emprestimo_livros.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoanRequestDTO {

    @NotNull(message = "O ID do cliente é obrigatório")
    private Long customerId;

    @NotEmpty(message = "A lista de IDs de livros não pode estar vazia")
    private List<Long> bookIds;
    
}

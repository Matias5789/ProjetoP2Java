package com.biblioteca.emprestimo_livros.mapper;

import com.biblioteca.emprestimo_livros.dto.LoanResponseDTO;
import com.biblioteca.emprestimo_livros.model.Loan;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class LoanMapper {
    
    public LoanResponseDTO toLoanResponseDTO(Loan loan) {
        LoanResponseDTO dto = new LoanResponseDTO();
        dto.setId(loan.getId());
        dto.setCustomerId(loan.getCustomer().getId());
        dto.setCustomerName(loan.getCustomer().getName());
        dto.setBookTitles(loan.getBooks().stream().map(book -> book.getTitle()).collect(Collectors.toList()));
        dto.setCreatedDate(loan.getCreatedDate());
        dto.setCompletedDate(loan.getCompletedDate());
        dto.setStatus(loan.getStatus().toString());
        return dto;
    }
}

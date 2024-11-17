package com.biblioteca.emprestimo_livros.DTO;

import java.util.List;

public class LoanRequestDTO {
    private Long customerId;
    private List<Long> bookIds;
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public List<Long> getBookIds() {
        return bookIds;
    }
    public void setBookIds(List<Long> bookIds) {
        this.bookIds = bookIds;
    }
}

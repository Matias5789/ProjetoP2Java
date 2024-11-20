package com.biblioteca.emprestimo_livros.repositorys;

import com.biblioteca.emprestimo_livros.model.Customer;
import com.biblioteca.emprestimo_livros.model.CustomerStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c")
    List<Customer> findAllCustomers();

    @Query("SELECT c FROM Customer c WHERE c.status = ?1")
    List<Customer> findCustomersByStatus(CustomerStatus status);

    @Query("SELECT c FROM Customer c WHERE c.name = ?1")
    List<Customer> findCustomerByName(String name);

    @Query("SELECT c FROM Customer c WHERE c.birthDate = :birthDate")
    Optional<Customer> findByBirthDate(@Param("birthDate") LocalDate birthDate);
    
}

package com.biblioteca.emprestimo_livros.controller;

import com.biblioteca.emprestimo_livros.model.Customer;
import com.biblioteca.emprestimo_livros.model.CustomerStatus;
import com.biblioteca.emprestimo_livros.model.Loan;
import com.biblioteca.emprestimo_livros.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable String name) {
        return ResponseEntity.ok(customerService.findCustomerByName(name));
    }

    @GetMapping("/status/{status}")
    public List<Customer> getCustomerByStatus(@PathVariable("status") String status) {
    try {
        CustomerStatus customerStatus = CustomerStatus.valueOf(status.toUpperCase());
        return customerService.findCustomersByStatus(customerStatus);
    } catch (IllegalArgumentException e) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid status value: " + status);
    }
    }

    @GetMapping("/birthdate/{birthDate}")
        public ResponseEntity<Customer> getCustomerByBirthDate(@PathVariable LocalDate birthDate) {
        Customer customer = customerService.findByBirthDate(birthDate);
        return ResponseEntity.ok(customer);
    }

     @GetMapping("/{id}/loans")
    public ResponseEntity<List<Loan>> getLoansByCustomerId(@PathVariable Long id) {
        List<Loan> loans = customerService.getLoansByCustomerId(id);
        return ResponseEntity.ok(loans);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Customer> updateCustomerStatus(@PathVariable Long id, @RequestParam CustomerStatus status) {
        return ResponseEntity.ok(customerService.updateCustomerStatus(id, status));
    }
}

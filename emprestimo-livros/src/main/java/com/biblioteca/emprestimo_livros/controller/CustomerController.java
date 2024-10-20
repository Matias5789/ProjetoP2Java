package com.biblioteca.emprestimo_livros.controller;

import com.biblioteca.emprestimo_livros.model.Customer;
import com.biblioteca.emprestimo_livros.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findCustomerById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable String name) {
        return ResponseEntity.ok(customerService.findCustomersByName(name));
    }

    @GetMapping("/birthdate/{birthDate}")
    public ResponseEntity<List<Customer>> getCustomerByBirthDate(@PathVariable String birthDate) {
        return ResponseEntity.ok(customerService.findCustomersByBirthDate(birthDate));
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.createCustomer(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Customer> updateCustomerStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(customerService.updateCustomerStatus(id, status));
    }
}

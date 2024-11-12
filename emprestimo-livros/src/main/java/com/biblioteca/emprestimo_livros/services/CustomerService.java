package com.biblioteca.emprestimo_livros.services;

import com.biblioteca.emprestimo_livros.model.Customer;
import com.biblioteca.emprestimo_livros.repositorys.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    public List<Customer> findCustomersByStatus(String status) {
        return customerRepository.findCustomersByStatus(status);
    }

    public List<Customer> findCustomerByName(String name) {
        return customerRepository.findCustomerByName(name);
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}

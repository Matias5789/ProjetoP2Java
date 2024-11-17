package com.biblioteca.emprestimo_livros.services;

import com.biblioteca.emprestimo_livros.model.Customer;
import com.biblioteca.emprestimo_livros.model.CustomerStatus;
import com.biblioteca.emprestimo_livros.repositorys.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    public List<Customer> findCustomerByName(String name) {
        return customerRepository.findCustomerByName(name);
    }

    public List<Customer> findCustomersByStatus(CustomerStatus status) {
        return customerRepository.findCustomersByStatus(status);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    public Customer updateCustomerStatus(Long id, CustomerStatus status) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setStatus(status);
        return customerRepository.save(customer);
    }
}

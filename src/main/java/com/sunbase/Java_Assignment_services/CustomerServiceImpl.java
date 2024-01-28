package com.sunbase.Java_Assignment_services;

import java.awt.print.Pageable;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sunbase.Java_Assignment_entity.Customer;
import com.sunbase.Java_Assignment_repositories.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers(int page, int size, String sortBy, String search) {
        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<Customer> customerPage;

        if (search != null && !search.isEmpty()) {
            // Perform search based on the provided search term
            customerPage = customerRepository.findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrEmailIgnoreCaseContainingOrPhoneContaining(
                    search, search, search, search, pageable);
        } else {
            // Retrieve all customers if no search term is provided
            customerPage = customerRepository.findAll(pageable);
        }

        return customerPage.getContent();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        // Check if the customer with the given ID exists
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            return customerRepository.save(customer);
        }
        return null; // Customer with the given ID not found
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}

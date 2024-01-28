package com.sunbase.Java_Assignment_services;

import java.awt.print.Pageable;
import java.util.List;

import com.sunbase.Java_Assignment_entity.Customer;

public interface CustomerService {

	Customer createCustomer(Customer customer);

    List<Customer> getAllCustomers(int page, int size, String sortBy, String search);

    Customer getCustomerById(Long id);

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);
	
	
}

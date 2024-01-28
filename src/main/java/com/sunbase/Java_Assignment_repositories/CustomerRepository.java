package com.sunbase.Java_Assignment_repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunbase.Java_Assignment_entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer save(Optional<Customer> new_customer);
	
	// Custom query method to search for customers by first name and last name
    List<Customer> findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContaining(String firstName, String lastName);

    // Custom query method to search for customers by email
    List<Customer> findByEmailIgnoreCaseContaining(String email);

    // Custom query method to search for customers by phone
    List<Customer> findByPhoneContaining(String phone);

    // Paging and sorting for the list of all customers
    Page<Customer> findAll(java.awt.print.Pageable pageable);

	Page<Customer> findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrEmailIgnoreCaseContainingOrPhoneContaining(
			String search, String search2, String search3, String search4, java.awt.print.Pageable pageable);

}

package org.shahul.service;

import java.util.List;

import org.shahul.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers() ;
	
	public void saveCustomer(Customer customer) ;

	public Customer getCustomerById(int customerId);

	public void deleteCustomer(int customerId);

	public List<Customer> getCustomerByName(String name);
}

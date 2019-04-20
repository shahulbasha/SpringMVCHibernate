package org.shahul.dao;

import java.util.List;

import org.shahul.entity.Customer;

public interface CustomerDAO {

	public void saveCustomer(Customer customer) ;
	
	public Customer getCustomer(String id) ;
	
	public List<Customer> getCustomers() ;
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(int customerId);

	public Customer getCustomerById(int customerId);

	public List<Customer> getCustomerByName(String name);
}

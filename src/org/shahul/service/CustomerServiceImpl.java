package org.shahul.service;

import java.util.List;

import org.shahul.dao.CustomerDAO;
import org.shahul.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDAO customerDAO;
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomerById(int customerId) {
		return customerDAO.getCustomerById(customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		customerDAO.deleteCustomer(customerId);
		
	}

	@Override
	@Transactional
	public List<Customer> getCustomerByName(String name) {
		return customerDAO.getCustomerByName(name);
	}

}

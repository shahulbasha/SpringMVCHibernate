package org.shahul.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.shahul.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);		
	}

	@Override
	public Customer getCustomer(String id) {

		return null;
	}

	@Override
	public List<Customer> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer",Customer.class);
		return query.getResultList();
	}

	@Override
	public void updateCustomer(Customer customer) {

		
	}

	@Override
	public void deleteCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where customerId=:id");
		query.setParameter("id", customerId);
		query.executeUpdate();
		//session.delete(Customer.class,customerId);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class,customerId);
		return customer;
	}

	@Override
	public List<Customer> getCustomerByName(String name) {
		Query query=null;
		Session session = sessionFactory.getCurrentSession();
		if(name!=null&& name.trim().length()>0) {
			query=session.createQuery("from Customer where lower(lastName) like :customerName or lower(firstName) like :customerName");
			query.setParameter("customerName", "%"+name.toLowerCase()+"%");
		}
		else {
			query=session.createQuery("from Customer");
		}		
		return query.getResultList();
	}

}

package org.shahul.controller;

import java.util.List;

import org.shahul.dao.CustomerDAO;
import org.shahul.entity.Customer;
import org.shahul.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@GetMapping("/list")
	public String customerList(Model model) {
		model.addAttribute("customers",customerService.getCustomers());
		return "listCustomers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model model) {
		Customer customer=new Customer();
		model.addAttribute("customer",customer);
		return "addCustomer";
	}
	
	@PostMapping("/processForm")
	public String saveCustomer(@ModelAttribute Customer customer) {
		customerService.saveCustomer(customer);
		return "listCustomers";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showUpdateForm(@RequestParam("customerId") int customerId,Model model){		
		Customer customer=customerService.getCustomerById(customerId);
		model.addAttribute("customer",customer);
		return "addCustomer";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int customerId,Model model) {
		customerService.deleteCustomer(customerId);
		//return "redirect:/customer/list";
		return "listCustomers";
	}
	
	@GetMapping("/searchForm")
	public String searchCustomerByName(@RequestParam("searchName") String name,Model model) {
		List<Customer> customerList=customerService.getCustomerByName(name);
		model.addAttribute("customers",customerList);
		return "listCustomers";
	}

}

package com.nttdata.spring.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.spring.repository.Customers;
import com.nttdata.spring.services.CustomersManagementServiceI;

/**
 * Taller 5 Spring
 * 
 * Controller del cliente
 * 
 * @author ernestocf
 *
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomersManagementServiceI customerService;
	
	/**
	 * Mostrar clientes
	 * 
	 * @return
	 */
	@GetMapping(value = "/printCustomers")
	public @ResponseBody List<Customers> printAll() {
		return customerService.getAllCustomers();
	}
	
	/**
	 * Añadir nuevo cliente
	 * 
	 * @param newCustomers
	 */
	@GetMapping(value = "/newCustomers")
	public void insertCustomers(@ModelAttribute("customers") Customers newCustomers) {
		customerService.addCustomers(newCustomers);
	}
	
	/**
	 * Consultar clientes por su nombre completo
	 * 
	 * @param name
	 * @param surname
	 * @param secondSurname
	 * @return
	 */
	@RequestMapping("searchCustomers")
	public @ResponseBody List<Customers> searchByFullName(@RequestParam String name, @RequestParam String surname,
			@RequestParam String secondSurname) {
		return customerService.getCustomerByFullName(name, surname, secondSurname);
	}

	
	
}

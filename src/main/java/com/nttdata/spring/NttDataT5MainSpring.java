package com.nttdata.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.repository.Customers;
import com.nttdata.spring.services.CustomersManagementServiceI;

/**
 * Taller 5 Spring
 * 
 * Clase Principal
 * 
 * @author ernestocf
 *
 */
@SpringBootApplication()
public class NttDataT5MainSpring implements CommandLineRunner {

	@Autowired
	private CustomersManagementServiceI customerService;

	public static void main(String[] args) {
		SpringApplication.run(NttDataT5MainSpring.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Crear base de datos para consumir los servicios
		Customers c1 = customerService.createCustomers("Claudia", "Cano", "Juud", "20/09/2001", "11111111A");
		Customers c2 = customerService.createCustomers("Jorge", "Munoz", "Gímenez", "15/011/1985", "22222222B");
		Customers c3 = customerService.createCustomers("Alba", "Ferreira", "Villena", "14/04/2001", "33333333C");
		Customers c4 = customerService.createCustomers("Juan Miguel", "Jimenez", "Lopez", "20/05/1993", "44444444D");

		// Insertar los clientes
		customerService.addCustomers(c1);
		customerService.addCustomers(c2);
		customerService.addCustomers(c3);
		customerService.addCustomers(c4);

	}
}

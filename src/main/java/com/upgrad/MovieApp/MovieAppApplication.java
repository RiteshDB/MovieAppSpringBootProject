package com.upgrad.MovieApp;

import com.upgrad.MovieApp.Entities.Customer;
import com.upgrad.MovieApp.dao.CustomerDAO;
import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;


@SpringBootApplication
public class MovieAppApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(MovieAppApplication.class, args);
		//System.out.println(context.getBeanDefinitionCount());
		//System.out.println(Arrays.stream(context.getBeanDefinitionNames()).collect(Collectors.toList()).contains("sampleComponentClass"));

		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDaoImpl");
		Customer customer = new Customer();
		customer.setFirstName("Ritesh");
		customer.setLastName("Bhandari");
		customer.setUserName("ritesaha");
		customer.setPassword("kjafoeoiewr");
		customer.setDateOfBirth(LocalDateTime.of(1998, 05,20, 0, 0));

		System.out.println("Before saving customer: "+customer.toString());
		Customer savedCustomer = customerDAO.save(customer);

		System.out.println("After saving customer: "+savedCustomer.toString());

		Customer fetchCustomer = customerDAO.get(savedCustomer.getCustomerId());
		System.out.println("Customer retrived from DB: "+fetchCustomer);

		fetchCustomer.setUserName("loveUSahana");

		Customer updatedCustomer = customerDAO.update(fetchCustomer);
		System.out.println("After updating customer: "+updatedCustomer);

		customerDAO.delete(updatedCustomer);
		System.out.println("After deleting customer: "+customerDAO.get(updatedCustomer.getCustomerId()));

	}

	/**
	@RequestMapping(value = "/home")
	public String messageSample(){
		return "this is Spring boot project.";
	}
 	*/
}

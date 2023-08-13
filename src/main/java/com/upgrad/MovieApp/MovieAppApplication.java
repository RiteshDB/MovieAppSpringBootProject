package com.upgrad.MovieApp;

import com.upgrad.MovieApp.Entities.Customer;
import com.upgrad.MovieApp.Entities.Movie;
import com.upgrad.MovieApp.dao.CustomerDAO;
import com.upgrad.MovieApp.dao.MovieDAO;
import com.upgrad.MovieApp.service.MovieService;
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

        /**
         * Testing Movie Service implementation.
         */

        MovieService movieService = context.getBean(MovieService.class);

        Movie movie = new Movie("Don","This is sample movie",LocalDateTime.of(2023,8,25, 0, 0),120, "urlString","trailerURL");

        Movie savedMovie = movieService.acceptMovieDetails(movie);
        System.out.println("Saved movie: "+ savedMovie);

		Movie gotMovie = movieService.getMovieDetails(1);

        System.out.println("fetching movie by movie ID: "+gotMovie);



        //System.out.println(context.getBeanDefinitionCount());
		//System.out.println(Arrays.stream(context.getBeanDefinitionNames()).collect(Collectors.toList()).contains("sampleComponentClass"));

//CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDaoImpl");
//Customer customer = new Customer();
//customer.setFirstName("Ritesh");
//customer.setLastName("Bhandari");
//customer.setUserName("ritesaha");
//customer.setPassword("kjafoeoiewr");
//customer.setDateOfBirth(LocalDateTime.of(1998, 05,20, 0, 0));
//
//System.out.println("Before saving customer: "+customer.toString());
//Customer savedCustomer = customerDAO.save(customer);
//
//System.out.println("After saving customer: "+savedCustomer.toString());
//
//Customer fetchCustomer = customerDAO.get(savedCustomer.getCustomerId());
//System.out.println("Customer retrived from DB: "+fetchCustomer);
//
//fetchCustomer.setUserName("loveUSahana");
//
//Customer updatedCustomer = customerDAO.update(fetchCustomer);
//System.out.println("After updating customer: "+updatedCustomer);
//
//customerDAO.delete(updatedCustomer);
//System.out.println("After deleting customer: "+customerDAO.get(updatedCustomer.getCustomerId()));
//
//MovieDAO movieDAO = context.getBean(MovieDAO.class);
//
//Movie movie = new Movie("Don","This is sample movie",LocalDateTime.of(2023,8,25, 0, 0),120, "urlString","trailerURL");
//System.out.println("Before Saving Movie: "+movie);
//Movie savedMovie = movieDAO.save(movie);
//System.out.println("After saving movie: "+savedMovie);
//
	}

	/**
	@RequestMapping(value = "/home")
	public String messageSample(){
		return "this is Spring boot project.";
	}
 	*/
}

package com.upgrad.MovieApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;


@SpringBootApplication
public class MovieAppApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(MovieAppApplication.class, args);
		System.out.println(context.getBeanDefinitionCount());
		System.out.println(Arrays.stream(context.getBeanDefinitionNames()).collect(Collectors.toList()).contains("sampleComponentClass"));

	}

	/**
	@RequestMapping(value = "/home")
	public String messageSample(){
		return "this is Spring boot project.";
	}
 	*/
}

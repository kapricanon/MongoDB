package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application  {

	 public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }

	    @Bean
	    CommandLineRunner init(DomainRepository domainRepository) {

	        return args -> {

	            Domain obj = domainRepository.findOne(1L);
	            System.out.println(obj.toString());

	            Domain obj2 = domainRepository.findCustomByDomain("test");
	            System.out.println(obj2);
	            
	            Domain obj3 = domainRepository.findCustomById(1);
	            System.out.println(obj3);

	            int n = domainRepository.updateDomain("test", true);
	            System.out.println("Number of records updated : " + n);

	        };

	    }
}
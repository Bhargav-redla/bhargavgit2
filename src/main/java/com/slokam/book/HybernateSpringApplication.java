package com.slokam.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableAspectJAutoProxy
@OpenAPIDefinition(info=@Info(title = "Book", version="1.0",description="provides All related API"))
@ComponentScan({"com.slokam.book.aspectlogging, com.slokam.book.controller"})
public class HybernateSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HybernateSpringApplication.class, args);
	}

}

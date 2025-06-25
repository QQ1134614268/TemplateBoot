package com.it.springdoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringdocApplication {

	public static void main(String[] args) {
		System.out.println("http://localhost:20620/doc.html" );
		System.out.println("http://localhost:20620/swagger-ui/index.html");
		SpringApplication.run(SpringdocApplication.class, args);
	}

}

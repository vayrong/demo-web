package com.example.herokudemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestBookManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestBookManagementApplication.class, args);
	}

	// Setup data
//	@Profile("start")
//	@Bean
//	CommandLineRunner initDatabase(BookRepository bookRepository) {
//		return args ->{
//			bookRepository.save(new Book("Pháo Đài Số", "Dan Brown", new BigDecimal("150000")));
//			bookRepository.save(new Book("Bí mật của Phan Thiên Ân", "Tiến sĩ Alan", new BigDecimal("60000")));
//			bookRepository.save(new Book("Sức mạnh của thói quen", "Charles Duhigg", new BigDecimal("109000")));
//			bookRepository.save(new Book("Đàn ông sao Hoả, đàn bà sao Kim", "John Gray", new BigDecimal("200000")));
//			System.out.println("Create DB success");
//
//		};
//	}
}

package com.pepo.demo.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;

@EnableRabbit
@SpringBootApplication
public class DemoBackendApi2Application {

	public static void main(String[] args) {

		SpringApplication.run(DemoBackendApi2Application.class, args);
		System.out.println("API rodando!");
	}

}

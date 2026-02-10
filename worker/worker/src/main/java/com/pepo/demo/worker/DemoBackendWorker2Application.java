package com.pepo.demo.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoBackendWorker2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoBackendWorker2Application.class, args);
		System.out.println("worker rodando");

//		ctx.getBean(EmailService.class).enviarMail();

	}

}

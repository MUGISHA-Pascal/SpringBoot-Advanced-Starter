package com.starter.backend;

import com.starter.backend.components.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext cxt = SpringApplication.run(BackendApplication.class, args);
		Student st = cxt.getBean(Student.class);
		Student dt = cxt.getBean(Student.class);
		System.out.println("Application Started...");
	}

}

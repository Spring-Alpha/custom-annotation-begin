package com.example.customannotation;

import com.example.customannotation.model.User;
import com.example.customannotation.service.LogExecutionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CustomAnnotationBeginApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomAnnotationBeginApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(LogExecutionService service){
		return args -> {
			service.logExecute();
			service.logExecute2();
			User model = new User("Md. Alif Bbau");
		};
	}
}

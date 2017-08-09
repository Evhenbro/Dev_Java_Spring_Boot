package ua.com.yarema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.com.yarema.repository.OpenCloseRepository;

@SpringBootApplication
public class DevJavaSpringBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DevJavaSpringBootApplication.class, args);
		OpenCloseRepository repository = run.getBean(OpenCloseRepository.class);
		System.out.println(repository.findAll());
		
	}
}

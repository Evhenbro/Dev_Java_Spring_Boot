package ua.com.yarema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.com.yarema.repository.CafeRepository;

@SpringBootApplication
public class DevJavaSpringBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DevJavaSpringBootApplication.class, args);
		CafeRepository repository = run.getBean(CafeRepository.class);
		System.out.println(repository.findAll());
		
	}
}

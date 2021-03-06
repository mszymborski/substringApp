package pl.substringapp.substringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.substringapp.substringapp.service.InputService;

@SpringBootApplication
public class SubstringApp implements ApplicationRunner {

	private InputService inputService;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication();
		application.setBannerMode(Banner.Mode.OFF);
		application.run(SubstringApp.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		inputService.processInputs(args);
	}

	@Autowired
	public void setInputService(InputService inputService) {
		this.inputService = inputService;
	}
}

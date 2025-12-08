package week1.week1Assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week1AssignmentApplication implements CommandLineRunner {

	@Autowired
	CakeBaker cakeBaker;
	public static void main(String[] args) {

		SpringApplication.run(Week1AssignmentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(cakeBaker.bakeCake());
	}
}

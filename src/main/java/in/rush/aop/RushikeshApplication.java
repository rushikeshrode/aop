package in.rush.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RushikeshApplication {

	public static void main(String[] args) {
		SpringApplication.run(RushikeshApplication.class, args);
	}

}

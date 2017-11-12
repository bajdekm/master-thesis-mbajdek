package pl.lodz.p.mgr;

import com.keyholesoftware.apistats.EnableApiStatistics;
import com.keyholesoftware.publish.swagger.PublishSwagger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SuperkanarApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperkanarApplication.class, args);
	}
}

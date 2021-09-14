package SpringBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication(scanBasePackages = "SpringBootApp")
@EntityScan(basePackages = "SpringBootApp.bean")
@EnableJpaRepositories(basePackages = "SpringBootApp.persistence")
@EnableEurekaClient
public class ACatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ACatalogServiceApplication.class, args);
	}

}

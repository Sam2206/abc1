package SpringBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "SpringBootApp")
@EntityScan(basePackages = "SpringBootApp.bean")
@EnableJpaRepositories(basePackages = "SpringBootApp.persistence")
@EnableEurekaClient
public class AssignmentOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentOrderServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}

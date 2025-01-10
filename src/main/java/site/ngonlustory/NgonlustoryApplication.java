package site.ngonlustory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication
public class NgonlustoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(NgonlustoryApplication.class, args);
        log.info("Swagger: http://localhost:8080/swagger-ui/index.html#/");
    }
}

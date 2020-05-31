package gpac.com;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@Slf4j
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "gpac.com.daos")
public class GpacApplication {
    public static void main(String[] args) {
        SpringApplication.run(GpacApplication.class, args);
    }
}

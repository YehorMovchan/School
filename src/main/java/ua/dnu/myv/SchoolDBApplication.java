package ua.dnu.myv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(exclude = SecurityAutoConfiguration.class,
        scanBasePackages = "ua.dnu.myv")
public class SchoolDBApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolDBApplication.class, args);
    }

}

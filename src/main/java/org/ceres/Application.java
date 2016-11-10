package org.ceres;

import org.ceres.entity.Expense;
import org.ceres.entity.UserDetailsServiceImpl;
import org.ceres.repoistory.ExpenseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Spring boot config
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(ExpenseRepository repository) {
        return (args) -> {
            repository.save(new Expense("title", "dessc", 200.0));
            repository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }
}

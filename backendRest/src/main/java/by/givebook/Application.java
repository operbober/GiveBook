package by.givebook;

/**
 * Created by operb_000 on 07.10.2015.
 */
import by.givebook.entities.library.Author;
import by.givebook.entities.account.User;
import by.givebook.entities.library.Work;
import by.givebook.services.SimpleServiceImpl;
import by.givebook.services.SimpleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    public SimpleService<Work> workService() {
        return new SimpleServiceImpl<Work>() { };
    }

    @Bean
    public SimpleService<User> userService() {
        return new SimpleServiceImpl<User>() { };
    }

    @Bean
    public SimpleService<Author> authorService() {
        return new SimpleServiceImpl<Author>() { };
    }
}


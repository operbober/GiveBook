package by.givebook;

/**
 * Created by operb_000 on 07.10.2015.
 */
import by.givebook.entities.library.Author;
import by.givebook.entities.account.User;
import by.givebook.entities.library.Genre;
import by.givebook.entities.library.Work;
import by.givebook.entities.offer.*;
import by.givebook.services.NamedService;
import by.givebook.services.impl.NamedServiceImpl;
import by.givebook.services.impl.SimpleServiceImpl;
import by.givebook.services.SimpleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableJpaRepositories(value = "by.givebook.repositories")
@ComponentScan
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }


    /*BEANS FOR SERVICES*/
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

    @Bean
    public NamedService<Genre> genreService() {
        return new NamedServiceImpl<Genre>() { };
    }

    @Bean
    public NamedService<BookCondition> bookConditionService() {
        return new NamedServiceImpl<BookCondition>() { };
    }

    @Bean
    public NamedService<BookType> bookTypeService() {
        return new NamedServiceImpl<BookType>() { };
    }

    @Bean
    public NamedService<BookLanguage> bookLanguageService() {
        return new NamedServiceImpl<BookLanguage>() { };
    }

    @Bean
    public SimpleService<Book> bookService() {
        return new SimpleServiceImpl<Book>() { };
    }

    @Bean
    public NamedService<OfferType> offerTypeService() {
        return new NamedServiceImpl<OfferType>() { };
    }
}


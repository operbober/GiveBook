package by.givebook;

/**
 * Created by operb_000 on 07.10.2015.
 */
import by.givebook.entities.account.User;
import by.givebook.entities.library.Genre;
import by.givebook.entities.offer.BookCondition;
import by.givebook.entities.offer.BookLanguage;
import by.givebook.entities.offer.BookType;
import by.givebook.entities.offer.OfferType;
import by.givebook.repositories.account.UserRepository;
import by.givebook.repositories.library.GenreRepository;
import by.givebook.repositories.offer.BookConditionRepository;
import by.givebook.repositories.offer.BookLanguageRepository;
import by.givebook.repositories.offer.BookTypeRepository;
import by.givebook.repositories.offer.OfferTypeRepository;
import by.givebook.services.NamedService;
import by.givebook.services.SimpleService;
import by.givebook.services.impl.NamedServiceImpl;
import by.givebook.services.impl.SimpleServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }


    /*BEANS FOR SERVICES*/
    @Bean
    public SimpleService<User> userService() {
        return new SimpleServiceImpl<User, UserRepository>() { };
    }

    @Bean
    public NamedService<Genre> genreService() {
        return new NamedServiceImpl<Genre, GenreRepository>() { };
    }

    @Bean
    public NamedService<BookCondition> bookConditionService() {
        return new NamedServiceImpl<BookCondition, BookConditionRepository>() { };
    }

    @Bean
    public NamedService<BookType> bookTypeService() {
        return new NamedServiceImpl<BookType, BookTypeRepository>() { };
    }

    @Bean
    public NamedService<BookLanguage> bookLanguageService() {
        return new NamedServiceImpl<BookLanguage, BookLanguageRepository>() { };
    }

    @Bean
    public NamedService<OfferType> offerTypeService() {
        return new NamedServiceImpl<OfferType, OfferTypeRepository>() { };
    }
}


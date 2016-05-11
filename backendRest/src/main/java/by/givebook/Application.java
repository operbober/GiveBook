package by.givebook;

/**
 * Created by operb_000 on 07.10.2015.
 */
import by.givebook.entities.library.Genre;
import by.givebook.entities.library.Quote;
import by.givebook.repositories.NamedRepository;
import by.givebook.entities.offer.BookCondition;
import by.givebook.entities.offer.BookLanguage;
import by.givebook.entities.offer.BookType;
import by.givebook.entities.offer.OfferType;
import by.givebook.repositories.SimpleRepository;
import by.givebook.services.NamedService;
import by.givebook.services.SimpleService;
import by.givebook.services.impl.NamedServiceImpl;
import by.givebook.services.impl.SimpleServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    /* BEANS FOR SERVICES */
    @Bean
    public NamedService<Genre> genreService() {
        return new NamedServiceImpl<Genre, NamedRepository<Genre>>() { };
    }

    @Bean
    public NamedService<BookCondition> bookConditionService() {
        return new NamedServiceImpl<BookCondition, NamedRepository<BookCondition>>() { };
    }

    @Bean
    public NamedService<BookType> bookTypeService() {
        return new NamedServiceImpl<BookType, NamedRepository<BookType>>() { };
    }

    @Bean
    public NamedService<BookLanguage> bookLanguageService() {
        return new NamedServiceImpl<BookLanguage, NamedRepository<BookLanguage>>() { };
    }

    @Bean
    public NamedService<OfferType> offerTypeService() {
        return new NamedServiceImpl<OfferType, NamedRepository<OfferType>>() { };
    }

    @Bean
    public SimpleService<Quote> quoteService() {
        return new SimpleServiceImpl<Quote, SimpleRepository<Quote>>() { };
    }
}


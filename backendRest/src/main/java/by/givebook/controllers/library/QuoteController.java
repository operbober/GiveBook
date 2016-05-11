package by.givebook.controllers.library;

import by.givebook.controllers.GenericController;
import by.givebook.entities.library.Quote;
import by.givebook.services.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Default class description.
 *
 * @author P.Sinitsky.
 * @date 11.05.2016.
 */

@RestController
@RequestMapping("/quotes")
public class QuoteController extends GenericController<Quote, SimpleService<Quote>> {

    @Autowired
    protected QuoteController(@Qualifier("quoteService") SimpleService<Quote> service) {
        super(service);
    }
}

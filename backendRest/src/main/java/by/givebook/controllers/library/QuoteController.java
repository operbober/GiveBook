package by.givebook.controllers.library;

import by.givebook.controllers.GenericController;
import by.givebook.entities.library.Quote;
import by.givebook.entities.library.Work;
import by.givebook.services.SimpleService;
import by.givebook.services.library.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Default class description.
 *
 * @author P.Sinitsky.
 * @date 11.05.2016.
 */

@RestController
@RequestMapping("/quotes")
public class QuoteController extends GenericController<Quote, QuoteService> {

    @Autowired
    protected QuoteController(QuoteService service) {
        super(service);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/random")
    protected Quote getRandom(){
        return service.getRandom();
    }
}

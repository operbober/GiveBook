package by.givebook.controllers.offer;

import by.givebook.controllers.GenericController;
import by.givebook.entities.offer.BookLanguage;
import by.givebook.services.NamedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 11.03.2016
 */
@RestController
@RequestMapping("/bookLanguages")
public class BookLanguageController extends GenericController<BookLanguage, NamedService<BookLanguage>> {

    @Autowired
    protected BookLanguageController(@Qualifier("bookLanguageService") NamedService<BookLanguage> service) {
        super(service);
    }
}

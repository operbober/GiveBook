package by.givebook.controllers.offer;

import by.givebook.controllers.SimpleController;
import by.givebook.entities.offer.BookCondition;
import by.givebook.services.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Default class description.
 *
 * @author P.Sinitski
 * @version 1.0
 * @since 04.03.2016
 */
@RestController
@RequestMapping("/bookConditions")
public class BookConditionController extends SimpleController<BookCondition> {

    @Autowired
    public BookConditionController(@Qualifier("bookConditionService") SimpleService<BookCondition> service) {
        super(service);
    }
}

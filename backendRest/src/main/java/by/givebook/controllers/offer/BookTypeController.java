package by.givebook.controllers.offer;

import by.givebook.controllers.GenericController;
import by.givebook.entities.offer.BookType;
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
@RequestMapping("/bookTypes")
public class BookTypeController extends GenericController<BookType,SimpleService<BookType>> implements javax.servlet.Filter {

    @Autowired
    public BookTypeController(@Qualifier("bookTypeService") SimpleService<BookType> service) {
        super(service);
    }
}

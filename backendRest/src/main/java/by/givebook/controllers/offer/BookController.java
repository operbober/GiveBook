package by.givebook.controllers.offer;

import by.givebook.controllers.SimpleEntityController;
import by.givebook.entities.offer.Book;
import by.givebook.services.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Default class description.
 *
 * @author P.Sinitsky.
 * @version ${VERSION}.
 */
@RestController
@RequestMapping("/books")
public class BookController extends SimpleEntityController<Book> {

    @Autowired
    protected BookController(@Qualifier("bookService") SimpleService<Book> service) { super(service); }
}

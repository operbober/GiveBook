package by.givebook.controllers.offer;

import by.givebook.controllers.GenericController;
import by.givebook.entities.offer.Book;
import by.givebook.services.SimpleService;
import by.givebook.services.offer.BookService;
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
public class BookController extends GenericController<Book,BookService> implements javax.servlet.Filter {

    @Autowired
    protected BookController(BookService service) { super(service); }
}

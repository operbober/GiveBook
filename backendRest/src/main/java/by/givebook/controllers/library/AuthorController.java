package by.givebook.controllers.library;

import by.givebook.controllers.GenericController;
import by.givebook.entities.library.Author;
import by.givebook.services.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
* Default class description.
*
* @author  P.Sinitski
* @version 1.0
* @since   01.03.2016
*/
@RestController
@RequestMapping("/authors")
public class AuthorController extends GenericController<Author,SimpleService<Author>> implements javax.servlet.Filter {

    @Autowired
    public AuthorController(@Qualifier("authorService") SimpleService<Author> service) {
        super(service);
    }
}

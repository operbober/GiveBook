package by.givebook.controllers.library;

import by.givebook.controllers.SimpleController;
import by.givebook.entities.library.Author;
import by.givebook.services.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by operb_000 on 01.03.2016.
 */

@RestController
@RequestMapping("/authors")
public class AuthorController extends SimpleController<Author> {

    @Autowired
    public AuthorController(@Qualifier("authorService") SimpleService<Author> service) {
        super(service);
    }
}
